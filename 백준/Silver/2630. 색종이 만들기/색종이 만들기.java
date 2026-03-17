import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		int W = 0;
		int B = 0;
		
		boolean[][] divided = new boolean[N][N];
		int currN = N;
		while(currN > 0) {
			for(int i = 0; i < N; i+=currN) {
				for(int j = 0; j < N; j+=currN) {
					if(!divided[i][j]) {
						int wCount = 0;
						int bCount = 0;
						for(int k = i; k < i+currN; k++) {
							for(int l = j; l < j+currN; l++) {
								if(paper[k][l] == 0) {
									wCount++;
								} else {
									bCount++;
								}
							}
						}
						if(wCount == 0 || bCount == 0) {
							if(wCount == 0) {
								B++;
							} else if(bCount == 0) {
								W++;
							}
							for(int k = i; k < i+currN; k++) {
								for(int l = j; l < j+currN; l++) {
									divided[k][l] = true;
								}
							}
						}
					}
				}
			}
			currN /= 2;
		}
		
		System.out.println(W);
		System.out.println(B);
	}
}
