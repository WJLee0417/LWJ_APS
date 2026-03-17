import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N*2-1];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N*2-1; j++) {
				map[i][j] = ' ';
			}
		}
		drawStar(N, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N*2-1; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void drawStar(int length, int r, int c) {
		if(length == 3) {
			map[r][c] = '*';
			map[r+1][c-1] = '*';
			map[r+1][c+1] = '*';
			for(int i = c-2; i <= c+2; i++) {
				map[r+2][i] = '*';
			}
			return;
		}
		
		int half = length / 2;
		
		drawStar(half, r, c);
		drawStar(half, r + half, c - half);
		drawStar(half, r + half, c + half);
	}
}