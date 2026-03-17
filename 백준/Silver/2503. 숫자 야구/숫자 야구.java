import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[] questions = new String[N];
		int[] strikes = new int[N];
		int[] balls = new int[N];
		
		for(int i = 0; i < N; i++) {
			questions[i] = sc.next();
			strikes[i] = sc.nextInt();
			balls[i] = sc.nextInt();
		}
		
		int ans = 0;
		
		for (int i = 123; i <= 987; i++) {
			String numStr = String.valueOf(i);
			
			if(numStr.contains("0")) continue;
			if(numStr.charAt(0) == numStr.charAt(1) ||
				numStr.charAt(0) == numStr.charAt(2) ||
				numStr.charAt(1) == numStr.charAt(2)) {
				continue;
			}
			
			boolean isPass = true;
			for(int j = 0; j < N; j++) {
				int s_count = 0;
				int b_count = 0;
				for(int a = 0; a < 3; a++) {
					for(int b = 0; b < 3; b++) {
						if(numStr.charAt(a) == questions[j].charAt(b)) {
							if(a == b) s_count++;
							else b_count++;
						}
					}
				}
				
				if(strikes[j] != s_count || balls[j] != b_count) {
					isPass = false;
					break;
				}
			}
			
			if(isPass) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
