package step1;

/**
 * 과일 가져가기, 상
 */
public class Ps06 {
    public static void main(String[] args){
        Ps06 T = new Ps06();

        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }

    /**
     * 주어진 과일 배열에서 최소값을 찾아 반환
     */
    public int getMin(int[] fruit) {
        int min = Integer.MAX_VALUE;
        for (int x : fruit) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }

    /**
     * 최소값이 정확히 하나만 존재하는지 검사
     * @return true면 유일한 최소값, false면 최소값 중복
     */
    public boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int x : fruit) {
            if (x == min) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    /**
     * 최소값을 가진 바구니의 인덱스(0:A, 1:B, 2:C) 반환
     */
    public int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < 3; i++) {
            if (fruit[i] == min) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 학생들 간 과일 교환 시뮬레이션 후,
     * 각 학생이 최종적으로 가져가는 과일(가장 적게 든 바구니 개수)의 합을 반환
     */
    public int solution(int[][] fruit) {
        int n = fruit.length;
        int[] exchanged = new int[n]; // 교환 완료된 학생 표시
        int answer = 0;

        // 학생 i를 기준으로, 아직 교환하지 않았고 최소값이 유일한 경우
        for (int i = 0; i < n; i++) {
            if (exchanged[i] == 1) continue;          // 이미 교환된 학생 건너뛰기
            if (!isMinUnique(fruit[i])) continue;     // 최소값 중복 시 건너뛰기

            // i와 교환할 j 탐색
            for (int j = i + 1; j < n; j++) {
                if (exchanged[j] == 1) continue;
                if (!isMinUnique(fruit[j])) continue;

                int ai = getMinIndex(fruit[i]);      // i 학생 최소 바구니
                int aj = getMinIndex(fruit[j]);      // j 학생 최소 바구니

                // 서로 다른 바구니끼리, 과일이 남아 있어야 교환 가능
                if (ai != aj
                        && fruit[i][aj] > 0
                        && fruit[j][ai] > 0
                        // 교환 후 둘 다 최소값이 증가하는지 확인
                        && fruit[i][ai] + 1 <= fruit[i][aj] - 1
                        && fruit[j][aj] + 1 <= fruit[j][ai] - 1
                ) {
                    // 실제 교환: i가 ai→aj, j가 aj→ai
                    fruit[i][ai]++;
                    fruit[i][aj]--;
                    fruit[j][aj]++;
                    fruit[j][ai]--;

                    exchanged[i] = 1;  // i, j 모두 교환 처리
                    exchanged[j] = 1;
                    break;             // i는 한 번만 교환하므로 내부 루프 탈출
                }
            }
        }

        for (int[] f : fruit) {
            answer += getMin(f);
        }
        return answer;
    }
}