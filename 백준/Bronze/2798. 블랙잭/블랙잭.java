import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		List<Integer> blackjak = new ArrayList<>();
		
		// 3중으로 for문 돌려보자.
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					int a = arr[i];
					int b = arr[j];
					int c = arr[k];
					if(a+b+c <= M) {
						blackjak.add(a+b+c);
					}
				}
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		
		for(int n : blackjak) {
			maxValue = Math.max(maxValue, n);
		}
		
		System.out.println(maxValue);
	}
}	
