import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] cal;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		cal = new int[M];
		visited = new boolean[N];
		
		perm(0);
 	}
	
	static void perm(int depth) {
		if(depth == M) {
			for(int n : cal) {
				System.out.print(n+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				cal[depth] = arr[i];
				perm(depth+1);
				visited[i] = false;
			}
		}
	}
}