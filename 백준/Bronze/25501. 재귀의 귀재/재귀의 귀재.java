import java.util.Scanner;

public class Main {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String input = sc.next();
			ans = 0;
			System.out.println(isPalindrome(input)+" "+ans);
		}
	}
	
	static int recursion(String s, int l, int r) {
		if(l >= r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else {
			ans++;
			return recursion(s, l+1, r-1);
		}
	}
	
	static int isPalindrome(String s) {
		ans++;
		return recursion(s, 0, s.length()-1);
	}
}