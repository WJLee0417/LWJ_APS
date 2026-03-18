import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static List<Integer>[] adj;
	static int[] visited;
	static int order = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		visited = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for(int i = 1; i < N+1; i++) {
			Collections.sort(adj[i], Collections.reverseOrder());
		}
		
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N+1; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int node) {
		visited[node] = order;
		order++;
		
		for(int next: adj[node]) {
			if(visited[next] == 0) {
				dfs(next);
			}
		}
	}
}