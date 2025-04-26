package stpe2;

import java.util.HashMap;

public class Ps04 {
    public static void main(String[] args){
        Ps04 T = new Ps04();

        System.out.println(T.ps04(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5)); // 5
        System.out.println(T.ps04(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5)); // 5
        System.out.println(T.ps04(new int[]{1, 2, 3, -3, 1, 2}, 3)); // 6
        System.out.println(T.ps04(new int[]{-1, 0, 1}, 0)); // 2
        System.out.println(T.ps04(new int[]{-1, -1, -1, 1}, 0)); // 1
    }

    public int ps04(int[] nums, int m){
        int answer = 0;
        int sum = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        for(int x : nums){
            sum += x;

            if (hashMap.containsKey(sum-m)) {
                answer += hashMap.get(sum-m);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

}
