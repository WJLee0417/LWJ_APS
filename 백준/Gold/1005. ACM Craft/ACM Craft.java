import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int T;
	static int N, K;
	static int[] build_time;
	static int[] in_degree;
	static int[] dp;
	static List<Integer>[] adj;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			build_time = new int[N+1];
			in_degree = new int[N+1];
			dp = new int[N+1];
			
			adj = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i = 1; i <= N; i++) {
				build_time[i] = sc.nextInt();
				dp[i] = build_time[i];
			}
			
			for(int i = 0; i < K; i++) {
				int U = sc.nextInt();
				int V = sc.nextInt();
				adj[U].add(V);
				in_degree[V] = in_degree[V] + 1;
			}
			
			int W = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 1; i <= N; i++) {
				if(in_degree[i] == 0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				
				for(int next : adj[now]) {
					dp[next] = Math.max(dp[next], dp[now] + build_time[next]);
					
					in_degree[next] = in_degree[next] - 1;
					
					if(in_degree[next] == 0) {
						queue.add(next);
					}
				}
			}
			
			System.out.println(dp[W]);
		}
	}
}
