import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int minCount = Integer.MAX_VALUE;
		
		if(N % 3 == 0) {
			minCount = Math.min(minCount, N/3);
		}
		
		int num = 1;
		while(num*5 <= N) {
			int count = 0;
			int target = N - num*5;
			if(target % 3 == 0) {
				count = num + target/3;
				minCount = Math.min(minCount, count);
			}
			num++;
		}
		
		System.out.println((minCount == Integer.MAX_VALUE) ? -1 : minCount);
	}
}