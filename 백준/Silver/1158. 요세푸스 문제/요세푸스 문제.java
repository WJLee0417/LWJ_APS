import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 요세푸스 문제

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> josephus = new LinkedList<>();
		List<Integer> ansList = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			josephus.offer(i);
		}
		
		while(josephus.size() != 0) {
			for(int i = 1; i <= K; i++) {
				if(i == K) {
					int ans = josephus.poll();
					ansList.add(ans);
				} else {
					int cycle = josephus.poll();
					josephus.offer(cycle);
				}
			}
		}
		
		System.out.print("<");
		for(int i = 0; i < ansList.size(); i++) {
			if(i == ansList.size()-1) {
				System.out.print(ansList.get(i));
			}
			else {
				System.out.print(ansList.get(i)+", ");
			}
		}
		System.out.println(">");
	}
}
