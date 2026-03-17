import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		backtrack(0, 1);
		System.out.print(sb);
	}
	
	static void backtrack(int depth, int start) {
		if(depth == M) {
			for(int i = 0; i <M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = start; i <= N; i++) {
			arr[depth] = i;
			backtrack(depth + 1, i);
		}
	}
}