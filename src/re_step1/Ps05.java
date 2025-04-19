package re_step1;

import step1.PS05;

/**
 * [재도전] 최대 길이 바이토닉 수열, 하
 */
public class Ps05 {
    public static void main(String[] args){
        PS05 T = new PS05();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));          // 5
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})); // 8
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})); // 6
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})); // 5
    }

    public int solution(int[] nums){
        // 바이토닉 수열 길이의 최댓값 탐색
        int maxLen = 0;

        return maxLen;
    }
}