import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = (int) Math.pow(2, N) - 1;
		
		sb = new StringBuilder();
		sb.append(K);
		sb.append("\n");
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(sb.toString());
	}
	
	static void hanoi(int n, int start, int mid, int to) {
		if(n == 1) {
			sb.append(start+" "+to+"\n");
			return;
		}
		
		hanoi(n - 1, start, to, mid);
		
		sb.append(start+" "+to+"\n");
		
		hanoi(n - 1, mid, start, to);
	}
}