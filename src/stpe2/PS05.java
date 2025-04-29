package stpe2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PS05 {
    public static void main(String[] args) {
        PS05 T = new PS05();

        /**
         * 1 -> "daniel"
         * 2 -> "john"
         * 3 -> "cody"
         * 4 -> "luis"
         */
        System.out.println(T.ps05(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.ps05(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.ps05(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.ps05(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }

    public String ps05(String[] votes, int k) {
        String answer = "";

        HashMap<String, HashSet<String>> vote = new HashMap<>(); // 추천자
        HashMap<String, Integer> candidate = new HashMap<>(); // 후보자
        HashMap<String, Integer> present = new HashMap<>(); // k번 이상 추천받은 후보자

        // 1. 투표
        for (String x : votes) {
            String key = x.split(" ")[0]; // 추천자
            String value = x.split(" ")[1]; // 후보자

            vote.putIfAbsent(key, new HashSet<>());
            // 추천자가 한 명의 후보를 추천
            vote.get(key).add(value);

            // 후보자가 받은 총 추천 수 1 증가
            candidate.put(value, candidate.getOrDefault(value, 0) + 1);
        }

        // 2. k번 이상 추천받은 경우
        int max = Integer.MIN_VALUE;
        for (String recommender : vote.keySet()) {
            int cnt = 0;
            for (String nominee : vote.get(recommender)) {
                // 후보자가 k번 이상 추천받았는지 확인
                if (candidate.getOrDefault(nominee, 0) >= k) {
                    cnt++;
                }
            }

            // k번 이상 추천받은 후보자
            present.put(recommender, cnt);

            // k번 이상 추천받은 후보자, 선물 받은 횟수 기록
            max = Math.max(max, cnt);
        }

        // 3. 선물을 가장 많이 받은, k번 이상 추천받은 후보자 필터링
        ArrayList<String> tmp = new ArrayList<>();
        for (String name : present.keySet()) {
            if (present.get(name) == max) {
                tmp.add(name);
            }
        }

        // 4. 사전순 정렬
        tmp.sort((a, b) -> a.compareTo(b));
        answer = tmp.get(0);

        return answer;
    }
}
