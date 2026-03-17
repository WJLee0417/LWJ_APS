import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		int determinant = a * e - b * d;
		
		int x = (c * e - b * f) / determinant;
		int y = (a * f - c * d) / determinant;
		System.out.println(x+" "+y);
	}
}
