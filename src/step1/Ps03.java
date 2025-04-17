package step1;

/**
 * 잃어버린 강아지, 상
 */
public class Ps03 {
    public static void main(String[] args) {
        Ps03 T = new Ps03();

        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.ps03(arr1));

        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.ps03(arr2));
    }

    public int ps03(int[][] board) {
        int n = board.length;
        int x1 = 0, y1 = 0; // 현수의 시작 위치 (2)
        int x2 = 0, y2 = 0; // 강아지의 시작 위치 (3)

        // 보드에서 현수(2)와 강아지(3)의 시작 좌표 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        // 방향 설정: 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
        int d1 = 0, d2 = 0;
        int count = 0;

        // 방향 이동을 위한 dx, dy 배열 (위, 오른쪽, 아래, 왼쪽 순)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 시뮬레이션
        count = simulation(board, count, x1, dx, d1, y1, dy, x2, d2, y2, n);

        return count >= 10000 ? 0 : count;
    }

    private static int simulation(int[][] board, int count, int x1, int[] dx, int d1, int y1, int[] dy, int x2, int d2, int y2, int n) {
        while (count < 10000) {
            count++;

            // 현수와 강아지 각각 다음 위치 계산
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];

            // 현수의 이동 가능 여부 검사: 범위 벗어나거나 울타리(1)를 만나면 방향 전환
            if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
                d1 = (d1 + 1) % 4;
            } else {
                x1 = nx1;
                y1 = ny1;
            }

            // 강아지의 이동 가능 여부 검사: 범위 벗어나거나 울타리(1)를 만나면 방향 전환
            if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) {
                d2 = (d2 + 1) % 4;
            } else {
                x2 = nx2;
                y2 = ny2;
            }

            // 두 객체가 같은 칸에 도달하면 중단
            if (x1 == x2 && y1 == y2) {
                break;
            }
        }
        return count;
    }
}
