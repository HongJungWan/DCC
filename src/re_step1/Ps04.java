package re_step1;

import java.util.Arrays;

/**
 * [재도전] 좌석 번호 구하기, 중
 */
public class Ps04 {
    public static void main(String[] args) {
        step1.Ps04 T = new step1.Ps04();
        System.out.println(Arrays.toString(T.ps04(6, 5, 12))); // 결과 [6, 3]
        System.out.println(Arrays.toString(T.ps04(6, 5, 20))); // 결과 [4, 3]
        System.out.println(Arrays.toString(T.ps04(6, 5, 30))); // 결과 [5, 4]
        System.out.println(Arrays.toString(T.ps04(6, 5, 31))); // 범위 초과 → [0, 0]
    }

    public int[] ps04(int c, int r, int k) {
        int[] answer = new int[2];

        return answer;
    }
}