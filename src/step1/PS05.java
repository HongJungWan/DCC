package step1;

/**
 * 최대 길이 바이토닉 수열, 하
 */
public class PS05 {
    public static void main(String[] args){
        PS05 T = new PS05();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));          // 5
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})); // 8
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})); // 6
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})); // 5
    }

    public int solution(int[] nums){
        int n = nums.length;
        int[] increase = new int[n];
        int[] decrease = new int[n];

        // 왼쪽부터, 증가 길이 계산
        increase[0] = 1;
        for (int i = 1; i < n; i++) {
            increase[i] = (nums[i] > nums[i - 1]) ? (increase[i - 1] + 1) : 1;
        }

        // 오른쪽부터, 감소 길이 계산
        decrease[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            decrease[i] = (nums[i] > nums[i + 1]) ? (decrease[i + 1] + 1) : 1;
        }

        // 바이토닉 수열 길이의 최댓값 탐색
        // 핵심 아이디어: 봉우리 지점
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            if (increase[i] > 1 && decrease[i] > 1) {
                maxLen = Math.max(maxLen, increase[i] + decrease[i] - 1);
            }
        }
        return maxLen;
    }
}

