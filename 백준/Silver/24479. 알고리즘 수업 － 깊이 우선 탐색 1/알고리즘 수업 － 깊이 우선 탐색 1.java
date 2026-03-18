import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, R;
	static List<Integer>[] adj; // 인접 리스트 배열
	static int[] visited;       // 각 정점을 '몇 번째'로 방문했는지 순서를 기록할 배열 (기본값 0)
	static int order = 1;       // 방문 순서 도장 카운터 (모든 재귀가 공유해야 하므로 전역 변수)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		R = sc.nextInt(); // 시작 정점
		
		// 1. 인접 리스트와 방문 배열 초기화 (1번 인덱스부터 쓰기 위해 N + 1 크기로 생성)
		adj = new ArrayList[N+1];
		visited = new int[N+1];
		
		// 배열의 각 칸마다 진짜 리스트(ArrayList) 객체를 하나씩 꽂아넣어 줌
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 2. 간선 정보 입력받기
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v); // u에서 v로 가는 길 개통
			adj[v].add(u); // v에서 u로 가는 길 개통 (무방향 그래프니까 양방향 필수)
		}
		
		// 3. 문제의 핵심 조건: "인접한 정점은 오름차순으로 방문한다!"
		// DFS 출발 전에 모든 리스트를 예쁘게 오름차순 정렬해 둠
		for(int i = 1; i < N+1; i++) {
			Collections.sort(adj[i]);
		}
		
		// 4. 시작 정점 R부터 DFS 깊이 우선 탐색 출발!
		dfs(R);
		
		// 5. 1번 정점부터 N번 정점까지 방문 순서 출력
		// (방문하지 못한 정점은 배열 초기값인 0이 자연스럽게 출력됨)
		for(int i = 1; i < N+1; i++) {
			System.out.println(visited[i]);
		}
	}
	
	// DFS 재귀 함수: 한 우물만 깊게 파고드는 탐색법
	static void dfs(int node) {
		// 1. 현재 정점에 도착했으니, 현재 순서(order)로 방문 도장 찍음
		visited[node] = order;
		
		// 2. 다음 방문할 정점을 위해 순서 카운터를 1 증가시켜 둠
		order++;
		
		// 3. 내 현재 위치(node)와 연결된 다음 정점(next)들을 하나씩 꺼내보면서
		for(int next: adj[node]) {
			// 만약 그 다음 정점이 아직 방문하지 않은 곳(0)이라면?
			if(visited[next] == 0) {
				dfs(next); // 망설이지 않고 바로 그 정점으로 깊게 파고든다!
			}
		}
	}
}