import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			Stack<Character> leftStack = new Stack<>();
			Stack<Character> rightStack = new Stack<>();
			
			char[] words = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			
			for(char c : words) {
				if(c == '<') {
					if(!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());
					}
				} else if (c == '>') {
					if(!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());
					}
				} else if (c == '-') {
					if(!leftStack.isEmpty()) {
						leftStack.pop();
					}
				} else {
					leftStack.push(c);
				}
			}
			
			while (!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			
			while(!rightStack.isEmpty()) {
				sb.append(rightStack.pop());
			}
			
			System.out.println(sb.toString());
		}
	}
}
