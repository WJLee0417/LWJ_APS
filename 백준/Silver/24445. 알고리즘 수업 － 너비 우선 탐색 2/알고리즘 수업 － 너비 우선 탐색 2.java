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
	static List<Integer>[] adj; // 정점들의 연결 상태를 저장할 인접 리스트 배열
	static int[] visited;       // 방문 '순서'를 기록할 배열
	static int order = 1;       // 방문 도장 카운터 (모두가 공유하는 전역 변수)
	
	// 🌟 BFS의 핵심 무기: 넓게 퍼져나가기 위한 대기열(Queue)
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// 1. 시간 초과 방어를 위한 초고속 입력기 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 쪼개기
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 2. 인접 리스트 및 방문 배열 초기화 (1번부터 쓰기 위해 N+1 사이즈)
		adj = new ArrayList[N+1];
		visited = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>(); // 각 칸마다 진짜 리스트 꽂아주기
		}
		
		// 3. 간선 정보 입력받기 (양방향 연결)
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); // 매 줄마다 새로 쪼개기
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		// 4. 🌟 문제의 핵심 조건: "인접한 정점은 내림차순으로 방문한다!"
		for(int i = 0; i < N+1; i++) {
			Collections.sort(adj[i], Collections.reverseOrder());
		}
		
		// 5. 시작 정점 R부터 BFS 탐색 출발!
		bfs(R);
		
		// 6. 초고속 출력을 위한 StringBuilder 세팅
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N+1; i++) {
			sb.append(visited[i]).append("\n"); // 출력값 차곡차곡 모으기
		}
		
		// 모아둔 출력값을 한 방에 쾅!
		System.out.print(sb);
	}
	
	// 물결이 퍼지듯 가까운 노드부터 탐색하는 BFS 메서드
	static void bfs(int node) {
		// 1. 시작 정점에 방문 순서 도장 쾅!
		visited[node] = order;
		order++;
		
		// 2. 시작 정점을 큐에 넣고 탐색 대기 상태로 만듦
		queue.offer(node);
		
		// 3. 큐가 텅텅 빌 때까지(모든 연결된 정점을 다 돌 때까지) 반복
		while(!queue.isEmpty()) {
			// 4. 큐의 맨 앞에 줄 서 있는 정점을 하나 꺼냄
			int u = queue.poll();
			
			// 5. 방금 꺼낸 정점과 연결된 이웃들을 하나씩 확인 (이미 내림차순 정렬됨!)
			for(int v : adj[u]) {
				// 6. 만약 이웃이 아직 방문하지 않은 곳(0)이라면?
				if(visited[v] == 0) {
					// 🌟 큐에 넣기 직전에 방문 도장부터 미리 찍어서 중복 예약 방지!
					visited[v] = order;
					order++;
					
					// 7. 이웃을 큐의 맨 뒤에 줄 세움 (다음 탐색 예약)
					queue.add(v);
				}
			}
		}
	}
}
