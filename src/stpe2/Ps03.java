package stpe2;

import java.util.HashMap;
import java.util.HashSet;

public class Ps03 {
    public int ps03(String s) {
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        for (char key : hashMap.keySet()) {
            while (hashSet.contains(hashMap.get(key))) {
                answer++;
                hashMap.put(key, hashMap.get(key) - 1);
            }

            if (hashMap.get(key) == 0) {
                continue;
            }
            hashSet.add(hashMap.get(key));
        }
        return answer;
    }

    public static void main(String[] args) {
        Ps03 T = new Ps03();
        
        System.out.println(T.ps03("aaabbbcc"));
        System.out.println(T.ps03("aaabbc"));
        System.out.println(T.ps03("aebbbbc"));
        System.out.println(T.ps03("aaabbbcccde"));
        System.out.println(T.ps03("aaabbbcccdddeeeeeff"));
    }
}
