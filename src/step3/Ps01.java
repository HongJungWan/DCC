package step3;

import java.util.HashSet;

public class Ps01 {
    public static void main(String[] args) {
        Ps01 T = new Ps01();

        System.out.println(T.ps01(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3})); // 5
        System.out.println(T.ps01(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0})); // 10
        System.out.println(T.ps01(new int[]{3, 3, 3, 3, 3, 3, 3, 3})); // 1
        System.out.println(T.ps01(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1})); // 7
        System.out.println(T.ps01(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7})); // 3
    }

    public int ps01(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        for (int x : set) {
            // x 바로 앞 숫자가 존재하므로, x는 시퀀스의 시작이 아니다.
            if (set.contains(x - 1)) {
                continue;
            }

            int cnt = 0;
            // 연속된 숫자가 나오면 계속 반복한다.
            while (set.contains(x)) {
                cnt++;
                x++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
