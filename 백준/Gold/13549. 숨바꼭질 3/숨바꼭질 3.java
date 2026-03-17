import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//N과 K 범위가 주어졌으므로, 방문 배열 생성
		int[] times = new int[100001];
		Deque<Integer> hide = new ArrayDeque<>();
		
		Arrays.fill(times, -1);
		
		hide.addFirst(N);
		times[N] = 0;
		
		while(!hide.isEmpty()) {
			int curr = hide.pollFirst();
			
			if(curr == K) {
				System.out.println(times[curr]);
				break;
			}
			
			if(curr*2 < times.length && times[curr*2] == -1) {
				times[curr*2] = times[curr];
				hide.addFirst(curr*2);
			}
			
			if(curr-1 >= 0 && times[curr-1] == -1) {
				times[curr-1] = times[curr] + 1;
				hide.addLast(curr-1);
			}
			
			if(curr+1 < times.length && times[curr+1] == -1) {
				times[curr+1] = times[curr] + 1;
				hide.addLast(curr+1);
			}
		}
	}
}
