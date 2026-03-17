import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] islandMap;
	static boolean[][] visited; 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int islandNum = 2; // 섬 번호(2부터 시작)
	static int totalIslands = 0; // 실제 섬의 총 개수
	
	// 다리 정보를 담을 클래스
	static class Edge {
		int start, end, length;
		public Edge(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}
	
	static List<Edge> bridgeList; // 가능한 모든 다리 후보들
	static boolean[] isSelected;  // 해당 다리를 지을 것인지 선택 여부
	static int minTotalCost = Integer.MAX_VALUE;  // 최종 정답(최소 비용)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		islandMap = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				islandMap[i][j] = sc.nextInt();
			}
		}
		
		// 1. 섬 번호 매기기(BFS)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(islandMap[i][j] == 1 && !visited[i][j]) {
					bfsIsland(i, j, islandNum);
					islandNum++;
					totalIslands++;
				}
			}
		}
		
		// 2. 다리 후보 추출 (4방향 델타탐색)
		bridgeList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) { // 섬의 해안가라면
				if (islandMap[i][j] >= 2) {
					extractBridges(i, j, islandMap[i][j]);
				}
			}
		}
		
		// 3. 부분집합 백트래킹 실행
		isSelected = new boolean[bridgeList.size()];
		dfs(0, 0, 0);
		
		// 모든 경우를 다 뒤졌는데도 갱신이 안 됐다면 연결 불가능
		if(minTotalCost == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minTotalCost);
		}
	}
	
	// bfsIsland - 섬을 고유 번호로 칠하는 BFS
	static void bfsIsland(int r, int c, int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		visited[r][c] = true;
		
		islandMap[r][c] = num;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(islandMap[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						islandMap[nr][nc] = num;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	// extractBridges - 4방향으로 직진하며 다리 견적서 뽑기
	static void extractBridges(int r, int c, int startIsland) {
		for(int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			int length = 0;
			
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
				if(islandMap[nr][nc] == startIsland) break;
				
				if(islandMap[nr][nc] == 0) { // 바다
					length++;
				} else { // 남의 섬
					if(length >= 2) {
						bridgeList.add(new Edge(startIsland, islandMap[nr][nc], length));
					}
					break;
				}
			}
		}
	}
	
	// dfs - 부분집합 백트래킹
	static void dfs(int index, int selectedCount, int currentCost) {
		// 가지치기: 이미 최소 비용을 넘었다면 더 볼 필요가 없다.
		if (currentCost >= minTotalCost) return;
		
		// 기저 조건: 모든 다리 후보를 다 물어봤다!
		if (index == bridgeList.size()) {
			// 고른 다리가 최소 (섬 개수 - 1)개 이상이어야 연결 가능
			if(selectedCount >= totalIslands - 1) {
				if(checkAllCollected()) {
					minTotalCost = currentCost;
				}
			}
			return;
		}
		
		// 선택지 A: 현재 다리 설치 O
		isSelected[index] = true;
		dfs(index+1, selectedCount+1, currentCost+bridgeList.get(index).length);
		
		// 선택지 B: 현재 다리 설치 X
		isSelected[index] = false;
		dfs(index+1, selectedCount, currentCost);
	}
	
	// checkAllConnected - 선택된 다리들로 모든 섬이 연결되었는지 BFS로 확인
	static boolean checkAllCollected() {
		// 인접 리스트 생성 (섬 번호가 2부터 시작하므로 islandNum 크기만큼 생성)
		List<Integer>[] adj = new ArrayList[islandNum];
		for(int i = 2; i < islandNum; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 선택된 다리(isSelected == true)들만 그래프로 연결
		for(int i = 0; i < bridgeList.size(); i++) {
			if(isSelected[i]) {
				Edge e = bridgeList.get(i);
				adj[e.start].add(e.end);
				adj[e.end].add(e.start);
			}
		}
		
		// 아무 섬(2번 섬)에서나 탐색 시작!
		boolean[] isVisitedIsland = new boolean[islandNum];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(2);
		isVisitedIsland[2] = true;
		int connectedCount = 1;  // 방문한 섬의 개수
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int next : adj[curr]) {
				if(!isVisitedIsland[next]) {
					isVisitedIsland[next] = true;
					connectedCount++;
					queue.add(next);
				}
			}
		}
		
		return connectedCount == totalIslands;
	}
}
