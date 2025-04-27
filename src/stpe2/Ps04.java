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

    /**
     * 해시맵을 이용한 m 합 카운팅:
     *   현재까지의 누적합 sum 에서 목표 m 을 뺀 값 (sum - m)이
     *   과거에 몇 번 등장했는지 기록된 count 만큼 answer에 더한다.
     */
    public int ps04(int[] nums, int m){
        int answer = 0;
        int sum = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1); // 누적합 0이 한 번 등장한 것으로 초기화

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
