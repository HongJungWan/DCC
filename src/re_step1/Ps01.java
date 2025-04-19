package re_step1;

import java.util.Arrays;

/**
 * [재도전] 사다리 타기, 하
 */
public class Ps01 {
    public static void main(String[] args) {
        step1.Ps01 T = new step1.Ps01();
        System.out.println(Arrays.toString(T.ps01(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.ps01(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.ps01(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.ps01(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

    public char[] ps01(int n, int[][] ladder) {
        char[] answer = new char[n];

        return answer;
    }
}