import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			Queue<int[]> papers = new LinkedList<>();

			
			for(int i = 0; i < N; i++) {
				papers.offer(new int[] {i, sc.nextInt()});
			}
			
			int printCount = 0;
			
			while (!papers.isEmpty()) {
				int[] current = papers.poll();
				boolean hasHigherPriority = false;
				
				for(int[] doc : papers) {
					if(doc[1] > current[1]) {
						hasHigherPriority = true;
						break;
					}
				}
				
				if(hasHigherPriority) {
					papers.offer(current);
				} else {
					printCount++;
					if(current[0] == M) {
						break;
					}
				}
			}
			
			System.out.println(printCount);
		}
	}
}