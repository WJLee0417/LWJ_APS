import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static List<Integer>[] adj;
	static boolean[] visited;						// 방문 배열 하나만 사용
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();	// 출력문은 전역 변수로
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());	// 시작 정점
		
		adj = new ArrayList[N+1];
		
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
		
		// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것부터 방문
		for(int i = 0; i < N+1; i++) {
			Collections.sort(adj[i]);
		}
		
		// DFS 탐색
		visited = new boolean[N+1];	// DFS용 방문 배열 준비
		dfs(R);
		
		sb.append('\n');			// DFS 끝나고 줄바꿈
		
		// BFS 탐색
		visited = new boolean[N+1];	// BFS용 방문 배열 새로 할당	
		bfs(R);
		
		// 출력
		System.out.print(sb);
	}
	
	static void dfs(int node) {
		visited[node] = true;		// 방문 도장
		
		// 방문하자마자 노드 번호 기록
		sb.append(node).append(' ');
		
		for(int next : adj[node]) {
			if(!visited[next]) {	// false(방문 안 함)라면?
				dfs(next);
			}
		}
	}
	
	static void bfs(int node) {
		// 시작 정점 방문 처리 및 큐 삽입
		visited[node] = true;
		q.offer(node);
		sb.append(node).append(' ');	// 시작 정점 발자취 기록
		
		while(!q.isEmpty()) {
			int u = q.poll();
			
			for(int v : adj[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
					
					// 큐에 넣을 때 바로 발자취
					sb.append(v).append(' ');
				}
			}
		}
	}
}