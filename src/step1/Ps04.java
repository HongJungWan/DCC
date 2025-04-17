package step1;

import java.util.Arrays;

/**
 * 좌석 번호 구하기, 중
 */
public class Ps04 {
    public static void main(String[] args) {
        Ps04 T = new Ps04();
        System.out.println(Arrays.toString(T.ps04(6, 5, 12))); // 결과 [6, 3]
        System.out.println(Arrays.toString(T.ps04(6, 5, 20))); // 결과 [4, 3]
        System.out.println(Arrays.toString(T.ps04(6, 5, 30))); // 결과 [5, 4]
        System.out.println(Arrays.toString(T.ps04(6, 5, 31))); // 범위 초과 → [0, 0]
    }

    public int[] ps04(int c, int r, int k) {
        int[] answer = new int[2];

        // k가 전체 좌석(c*r)보다 크면 불가능하므로 [0,0] 반환
        if (k > c * r) {
            return new int[]{0, 0};
        }

        // 좌석 상태 저장
        int[][] seat = new int[c][r];

        // 방향 이동을 위한 dx, dy 배열 (위, 오른쪽, 아래, 왼쪽 순)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 초기화
        int x = 0, y = 0;   // 0-based 인덱스: (0,0) 은 실제 좌표 (1,1)
        int count = 1;      // 현재 배정된 사람 번호
        int direction = 1;

        // 시뮬레이션
        while (count < k) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 위치가 범위를 벗어나거나 이미 배정된 칸이면 -> 시계 방향으로 전환
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                direction = (direction + 1) % 4;
                continue;
            }

            seat[x][y] = count;
            count++;

            x = nx;
            y = ny;
        }

        // 최종 위치(x,y)는 0-based 이므로 +1 해서 실제 좌표로 변환
        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }
}
