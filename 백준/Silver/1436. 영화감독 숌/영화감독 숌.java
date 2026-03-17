import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int num = 0;
		while(count < N) {
			num++;
			String numStr = Integer.toString(num);
			if(numStr.contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}
}