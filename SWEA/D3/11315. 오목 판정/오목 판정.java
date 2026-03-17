import java.util.Scanner;

class Solution {
	static int[] dr = {0, 1, 1, 1};
    static int[] dc = {1, 0, 1, -1};
    static int N;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new char[N][N];

            for(int i = 0; i < N; i++) {
                String line = sc.next();
                map[i] = line.toCharArray(); // toCharArray가 훨씬 빠름
            }

            boolean result = false;

            // 2. 모든 점을 시작점으로 가정
            outer: for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    // 돌이 있는 곳에서만 체크 시작
                    if(map[r][c] == 'o') {
                        if(check(r, c)) { // 오목이 발견되면
                            result = true;
                            break outer; // 2중 루프 탈출
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + (result ? "YES" : "NO"));
        }
    }

    // (r,c)에서 시작해서 5개가 연속되는지 확인
    static boolean check(int r, int c) {
        for(int d = 0; d < 4; d++) { // 4방향 탐색
            int cnt = 0;
            // 5칸을 연속으로 본다
            for(int k = 0; k < 5; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;

                // 범위 밖이거나, 돌이 없으면(또는 다른 돌이면) 끊김 -> 탈락
                if(!isIn(nr, nc) || map[nr][nc] != 'o') {
                    break;
                }
                cnt++;
            }
            // 끊기지 않고 5개 카운트했으면 성공!
            if(cnt == 5) return true;
        }
        return false;
    }

    // 범위 체크
    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
