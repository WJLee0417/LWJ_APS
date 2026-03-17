import java.util.Scanner;

public class Main{
	static int N, M;
	static int[] arr;
	static int[] cal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		cal = new int[M];
		
		comb(0, 0);
	}
	
	static void comb(int depth, int start) {
		if(depth == M) {
			for(int n : cal) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			cal[depth] = arr[i];
			comb(depth + 1, i + 1);
		}
	}
}