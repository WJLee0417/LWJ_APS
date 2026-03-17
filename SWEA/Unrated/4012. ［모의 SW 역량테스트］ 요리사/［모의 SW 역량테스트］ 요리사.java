import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] S;			// 시너지 배열
	static boolean[] visited;	// true: A음식, false: B음식
	static int minDiff;			// 정답(최소 차이)을 담을 전역 변수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			S = new int[N][N];
			visited = new boolean[N];
			minDiff = Integer.MAX_VALUE;	// 최솟값을 구해야 하니 초기값은 가장 큰 수
			
			// 시너지 맵 입력 받기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			
			// 깊이 0, A팀 0명, B팀 0명으로 탐색 시작!
			dfs(0, 0, 0);
			
			System.out.println("#" + tc + " " + minDiff);
		}
	}
	
	// depth: 현재 식재료 인덱스
	// aCount: A음식에 들어간 식재료 수
	// bCount: B음식에 들어간 식재료 수
	static void dfs(int depth, int aCount, int bCount) {
		
		if(aCount > N/2 || bCount > N/2) {
			return;
		}
		
		if(depth == N) {
			int sumA = 0;
			int sumB = 0;
			for(int i = 0;  i< N-1; i++) {
				for(int j = i+1; j < N; j++) {
					if(visited[i] == true && visited[j] == true) {
						sumA += S[i][j] + S[j][i];
					} else if(visited[i] == false && visited[j] == false) {
						sumB += S[i][j] + S[j][i];
					}
				}
			}
			int diff = Math.abs(sumA - sumB);
			minDiff = Math.min(minDiff, diff);
			return;
		}
		
		visited[depth] = true;
		dfs(depth + 1, aCount + 1, bCount);
		
		visited[depth] = false;
		dfs(depth + 1, aCount, bCount + 1);
	}
}
