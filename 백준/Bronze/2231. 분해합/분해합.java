import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int ans = 0;
		for(int i = 0; i < N; i++) {
			int targetNumber = i;
			int sum = 0;
			while(targetNumber > 0) {
				sum += targetNumber % 10;
				targetNumber /= 10;
			}
			if(i + sum == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}