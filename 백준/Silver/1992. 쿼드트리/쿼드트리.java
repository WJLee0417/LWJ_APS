import java.util.Scanner;

public class Main {
	static int N;
	static int[][] movie;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		movie = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) {
				movie[i][j] = line.charAt(j) - '0';
			}
		}
		
		quadTree(N, 0, 0);
	}
	static void quadTree(int size, int r, int c) {
		int result = check(r, c, size);
		
		if(result != -1) {
			System.out.print(result);
			return;
		}
		
		System.out.print("(");
		
		int half = size / 2;
		
		quadTree(half, r, c);
		quadTree(half, r, c+half);
		quadTree(half, r+half, c);
		quadTree(half, r+half, c+half);
		
		System.out.print(")");
	}
	
	static int check(int r, int c, int size) {
		int standard = movie[r][c];
		
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(movie[i][j] != standard) {
					return -1;
				}
			}
		}
		
		return standard;
	}
}