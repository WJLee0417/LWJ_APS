import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int minVal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		minVal = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		startAndLink(0, 0);
		System.out.println(minVal);
	}
	
	static void startAndLink(int depth, int start) {
		if(depth == N / 2) {
			int diff = calculateDiff();
			minVal = Math.min(minVal, diff);
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				startAndLink(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
	
	static int calculateDiff() {
		int startScore = 0;
		int linkScore = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) {
					startScore = startScore + map[i][j] + map[j][i];
				}
				
				if(visited[i] == false && visited[j] == false) {
					linkScore = linkScore + map[i][j] + map[j][i];
				}
			}
		}
		return Math.abs(startScore - linkScore);
	}
}