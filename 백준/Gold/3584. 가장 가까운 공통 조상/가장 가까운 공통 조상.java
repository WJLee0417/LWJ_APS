import java.util.Scanner;

public class Main {
	static int[] left;
	static int[] right;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			left = new int[N+1];
			right = new int[N+1];
			parent = new int[N+1];
			
			for(int i = 0; i < N-1; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				
				if(left[p] == 0) {
					left[p] = c;
				} else {
					right[p] = c;
				}
				
				parent[c] = p;
			}
			
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			boolean[] visited = new boolean[N+1];
			
			int curr = node1;
			while(curr != 0) {
				visited[curr] = true;
				curr = parent[curr];
			}
			
			int lca = 0;
			curr = node2;
			while(curr != 0) {
				if(visited[curr]) {
					lca = curr;
					break;
				}
				curr = parent[curr];
			}
			
			System.out.println(lca);
		}
	}
}
