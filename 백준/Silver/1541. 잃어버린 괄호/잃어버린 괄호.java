import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cal = sc.nextLine();
		
		int answer = Integer.MAX_VALUE;
		
		String[] minusTokens = cal.split("-");
		
		for(int i = 0; i < minusTokens.length; i++) {
			int temp = 0;
			
			String[] plusTokens = minusTokens[i].split("\\+");
			
			for(int j = 0; j < plusTokens.length; j++) {
				temp += Integer.parseInt(plusTokens[j]);
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = temp;
			} else {
				answer -= temp;
			}
		}
		
		System.out.println(answer);
	}
}
