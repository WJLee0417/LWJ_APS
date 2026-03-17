import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int T, N;
	static int[][] coreArr;
	static List<int[]> coreList;
	static int maxCore;
	static int minLineLength;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			maxCore = 0;
			minLineLength = Integer.MAX_VALUE;
			
			N = sc.nextInt();
			coreArr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					coreArr[i][j] = sc.nextInt();
				}
			}
			
			coreList = new ArrayList<>();
			
			int initialConnected = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(coreArr[i][j] == 1) {
						if(i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							initialConnected++;
						} else {
							coreList.add(new int[] {i, j});
						}
					}
				}
			}
			
			dfs(0, initialConnected, 0);
			System.out.println("#"+tc+" "+minLineLength);
		}
	}
	
	static void dfs(int idx, int connectedCore, int totalLength) {
		if(idx == coreList.size()) {
			if(connectedCore > maxCore) {
				maxCore = connectedCore;
				minLineLength = totalLength;
			}
			else if(connectedCore == maxCore) {
				minLineLength = Math.min(totalLength, minLineLength);
			}
			return;
		}
		
		int r = coreList.get(idx)[0];
		int c = coreList.get(idx)[1];
		
		for(int d = 0; d < 4; d++) {
			int wireLen = checkedAndDraw(r, c, d, 2);
			
			// 전선을 다 깔았다면?
			if(wireLen > 0) {
				// 깔려있는 상태 그대로 다음 코어로
				dfs(idx+1, connectedCore + 1, totalLength+wireLen);
				
				// 깔았던 전선을 다시 0으로 지우기
				checkedAndDraw(r, c, d, 0);
			}
		}
		
		dfs(idx + 1, connectedCore, totalLength);
	}
	
	static int checkedAndDraw(int r, int c, int dir, int value) {
		int nr = r;
		int nc = c;
		int length = 0;
		
		// 전선 깔기일 때(value == 2)
		if(value == 2) {
			while(true) {
				nr += dr[dir];
				nc += dc[dir];
				
				// 맵 밖으로 나가면? 장애물 없이 무사히 전원 연결
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
				
				// 가다가 빈칸이 아닌 무언가(코어 1, 다른 전선 2) 만나면?
				if(coreArr[nr][nc] != 0) {
					return 0;
				}
			}
		}
		
		nr = r;
		nc = c;
		
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			
			coreArr[nr][nc] = value;
			length++; // 깐(혹은 지문) 전선의 길이 측정
			
		}
		
		return length;
	}
}
