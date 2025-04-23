package stpe2;

import java.util.HashMap;

public class Ps01 {
    public static void main(String[] args) {
        Ps01 T = new Ps01();
        System.out.println(T.ps01("statitsics"));
        System.out.println(T.ps01("aabb"));
        System.out.println(T.ps01("stringshowtime"));
        System.out.println(T.ps01("abcdeabcdfg"));
    }

    public int ps01(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
