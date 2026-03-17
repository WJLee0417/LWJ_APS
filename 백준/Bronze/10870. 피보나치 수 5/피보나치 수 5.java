import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] fibo = new int[21];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[N]);
	}
}