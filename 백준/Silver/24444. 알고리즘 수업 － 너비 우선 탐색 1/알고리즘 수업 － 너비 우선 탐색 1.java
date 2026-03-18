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
	static int[] visited;
	
	// 줄서기(Queue) 객체 생성
	static Queue<Integer> queue = new LinkedList<>();
	static int order = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		visited = new int[N+1];
		
		// 1. 인접 리스트 초기화
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 2. 간선 정보 입력(양방향 연결)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		// 3. 문제 조건: 오름차순 방문
		// 각 정점의 인접리스트를 오름차순으로 정렬
		for(int i = 0; i < N+1; i++) {
			Collections.sort(adj[i]);
		}
		
		// 4. 시작 정점 R부터 넗게 퍼져나가는 BFS 탐색
		bfs(R);
		
		// 5. 방문 순서 출력
		for(int i = 1; i < N+1; i++) {
			System.out.println(visited[i]);
		}
	}
	
	// BFS: 물결이 퍼지듯 가벼운 곳부터 넓게 탐색하는 함수
	static void bfs(int node) {
		// 1. 시작 정점에 첫 번째 방문 도장
		visited[node] = order;
		order++; // 다음 순서 준비
		
		// 2. 시작 정점을 큐(대기열)에 넣고 탐색 대기(enqueue)
		queue.offer(node);
		
		// 3. 큐가 텅텅 빌때까지 무한 반복
		while(!queue.isEmpty()) {
			// 4. 큐 맨 앞에 서 있는 정점을 하나 꺼냄(dequeue)
			int u = queue.poll();
			
			// 5. 방금 꺼낸 정점과 연결된 이웃들을 하나씩 확인
			for(int v : adj[u]) {
				// 만약 그 이웃이 아직 한 번도 방문 안한 곳이라면?
				if(visited[v] == 0) {
					// 6. 큐에 넣기 직전에 방문 도장
					visited[v] = order;
					order++;
					
					// 7. 이웃을 큐 맨 뒤에 줄세움(enqueue)
					queue.add(v);
				}
			}
		}
	}
}