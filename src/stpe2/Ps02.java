package stpe2;

import java.util.Arrays;
import java.util.HashMap;

public class Ps02 {
    public static void main(String[] args) {
        Ps02 T = new Ps02();
        System.out.println(Arrays.toString(T.ps02("aaabc")));
        System.out.println(Arrays.toString(T.ps02("aabb")));
        System.out.println(Arrays.toString(T.ps02("abcde")));
        System.out.println(Arrays.toString(T.ps02("abcdeabc")));
        System.out.println(Arrays.toString(T.ps02("abbccddee")));
    }

    public int[] ps02(String s) {
        int[] answer = new int[5];
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String tmp = "abcde";

        for (char key : tmp.toCharArray()) {
            if (hashMap.getOrDefault(key, 0) > max) {
                max = hashMap.getOrDefault(key, 0);
            }
        }

        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = max - hashMap.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }
}
