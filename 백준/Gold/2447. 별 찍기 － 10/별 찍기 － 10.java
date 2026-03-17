import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				A[i][j] = ' ';
			}
		}
		
		makeStar(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(A[i]);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void makeStar(int r, int c, int size) {
		if(size == 1) {
			A[r][c] = '*';
			return;
		}
		
		int newSize = size / 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) {
					continue;
				}
				
				int nr = r + (i * newSize);
				int nc = c + (j * newSize);
				makeStar(nr, nc, newSize);
			}
		}
	}
}