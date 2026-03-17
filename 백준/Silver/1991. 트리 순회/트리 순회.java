import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] tree = new int[26][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left != '.') {
				tree[parent - 'A'][0] = left - 'A';
			} else {
				tree[parent - 'A'][0] = -1;
			}
			
			if(right != '.') {
				tree[parent - 'A'][1] = right - 'A';
			} else {
				tree[parent - 'A'][1] = -1;
			}
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	}
	
	static void preOrder(int node) {
		if(node == -1) return;
		System.out.print((char)(node + 'A'));
		preOrder(tree[node][0]);
		preOrder(tree[node][1]);
	}
	
	static void inOrder(int node) {
		if(node == -1) return;
		inOrder(tree[node][0]);
		System.out.print((char)(node + 'A'));
		inOrder(tree[node][1]);
	}
	
	static void postOrder(int node) {
		if(node == -1) return;
		postOrder(tree[node][0]);
		postOrder(tree[node][1]);
		System.out.print((char)(node + 'A'));
	}
	
}
