import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			x -= 1;
			y -= 1;
			
			boolean found = false;
			
			for(int k = x; k < M*N; k += M) {
				if(k % N == y) {
					System.out.println(k+1);
					found = true;
					break;
				}
			}
			
			if(!found) {
				System.out.println(-1);
			}
		}
	}
}
