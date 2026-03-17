import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 비숍
// 대각선 방향으로 움직일 수 있다. -> 대각선 4방향 델타 탐색
// 서로가 서로를 잡을 수 없는 위치 -> DFS + 백트래킹

public class Main {
	static int N;
	static int[][] chess;
	static boolean[][] visited;
	static List<int[]> blackCells;
	static List<int[]> whiteCells;
	static int maxBlack;
	static int maxWhite;
	
	static int[] dr = {-1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chess = new int[N][N];
		visited = new boolean[N][N];
		maxBlack = Integer.MIN_VALUE;
		maxWhite = Integer.MIN_VALUE;
		blackCells = new ArrayList<>();
		whiteCells = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				chess[i][j] = sc.nextInt();
				if(chess[i][j] == 1) {
					if((i + j) % 2 == 0) {
						blackCells.add(new int[] {i, j});
					}
					else if((i + j) % 2 == 1) {
						whiteCells.add(new int[] {i, j});
					}
				}
			}
		}
		
		backtrack(0, 0, blackCells, true);
		backtrack(0, 0, whiteCells, false);
		System.out.println(maxBlack + maxWhite);
	}
	
	static void backtrack(int depth, int count, List<int[]> cells, boolean isBlack) {
		if(depth == cells.size()) {
			if(isBlack == true) {
				maxBlack = Math.max(maxBlack, count);
			} else {
				maxWhite = Math.max(maxWhite, count);
			}
			return;
		}
		
		int curR = cells.get(depth)[0];
		int curC = cells.get(depth)[1];
		
		if(isValid(curR, curC)) {
			visited[curR][curC] = true;
			backtrack(depth + 1, count + 1, cells, isBlack);
			visited[curR][curC] = false;
		}
		
		backtrack(depth+1, count, cells, isBlack);
	}
	
	static boolean isValid(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(visited[nr][nc] == true) {
					return false;
				}
				
				nr = nr + dr[d];
				nc = nc + dc[d];
			}
		}
		return true;
	}
}
