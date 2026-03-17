import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] chess = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				chess[i][j] = line.charAt(j);
			}
		}
		
		int minCount = Integer.MAX_VALUE;
		
		// 2갈래로 분류
		// 8x8로 자르자.
		for(int i = 0; i < N-8+1; i++) {
			for(int j = 0; j < M-8+1; j++) {
				int count = 0;
				for(int k = i; k < i+8; k++) {
					for(int l = j; l < j+8; l++) {
						if(k % 2 == 0) {
							if(l % 2 == 0) {
								if(chess[k][l] != 'W') {
									count++;
								}
							}
							else if(l % 2 == 1) {
								if(chess[k][l] != 'B') {
									count++;
								}
							}
						}
						else if(k % 2 == 1) {
							if(l % 2 == 0) {
								if(chess[k][l] != 'B') {
									count++;
								}
							}
							else if(l % 2 == 1) {
								if(chess[k][l] != 'W') {
									count++;
								}
							}
						}
					}
				}
				count = Math.min(count, 64 - count);
				minCount = Math.min(minCount, count);
			}
		}
		System.out.println(minCount);
	}
}
