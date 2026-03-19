import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M;				// N(컴퓨터 수), M(네트워크 상에서 연결된 컴퓨터 쌍의 수)
	static List<Integer>[] adj;		// 인접 리스트 배열
	static boolean[] visited;		// 방문 여부 체크 배열
	static int count = 0;			// 총 감염된 컴퓨터 수를 셀 변수, 초기값 0
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// adj 배열, visited 배열 초기화(1번부터 사용하므로 N+1크기)
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// M번 반복하면서 양방향 간선 연결
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		// dfs 호출
		dfs(1);
		
		// 1번 컴퓨터 본인은 제외
		System.out.println(count-1);
	}
	
	static void dfs(int node) {
		visited[node] = true;	// 감염(방문) 도장
		count++;				// 감염된 컴퓨터 수 1 증가
		
		// 현재 컴퓨터와 연결된 다음 컴퓨터(next)들을 싹 다 순회
		for(int next : adj[node]) {
			if(!visited[next]) {	// 아직 감염 안 된 청정 구역이면?
				dfs(next);			// 바이러스 전파, 깊게 파고든다.
			}
		}
	}
}