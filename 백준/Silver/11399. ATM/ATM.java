import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] times = new int[N];
		for(int i = 0; i < N; i++) {
			times[i] = sc.nextInt();
		}
		
		Arrays.sort(times);
		
		int ans = 0;
		int cur = 0;
		for(int i = 0; i < N; i++) {
			ans += times[i] + cur;
			cur += times[i];
		}
		
		System.out.println(ans);
	}
}