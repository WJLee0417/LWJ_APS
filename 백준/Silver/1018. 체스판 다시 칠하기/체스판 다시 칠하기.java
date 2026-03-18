import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 세로 길이
		int M = sc.nextInt();	// 가로 길이
		
		// 상태 저장 2차원 배열
		char[][] chess = new char[N][M];
		
		// 보드의 각 줄을 입력받아 2차원 배열에 문자(char) 형태로 저장
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				chess[i][j] = line.charAt(j);
			}
		}
		
		// 다시 칠해야 하는 정사각형의 최소 개수를 저장할 변수
		// 최솟값을 찾아야 하므로 초기값은 가장 큰 정수값으로 설정
		int minCount = Integer.MAX_VALUE;
		
		// 전체 보드에서 8x8 크기로 잘라야 하는 모든 경우의 수를 탐색
		// 8x8 크기 확보해야 하므로 시작점의 범위는 N-8+1, M-8+1 까지
		for(int i = 0; i < N-8+1; i++) {
			for(int j = 0; j < M-8+1; j++) {
				int count = 0;	// 현재 8x8 체스판에서 다시 칠해야 하는 칸 수
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
