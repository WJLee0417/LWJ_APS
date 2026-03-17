import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null && !input.isEmpty()) {
			int N = Integer.parseInt(input);
			int length = (int) Math.pow(3, N);
			A = new char[length];
			for(int i = 0; i < length; i++) {
				A[i] = '-';
			}
			
			cantor(0, length);
			System.out.println(A);
		}
	}
	
	static void cantor(int start, int length) {
		if(length == 1) {
			return;
		}
		
		int sub_length = length / 3;
		
		int centerStart = start + sub_length;
		int centerFinish = start + sub_length * 2 - 1;
		
		for(int i = centerStart; i <= centerFinish; i++) {
			A[i] = ' ';
		}
		cantor(start, sub_length);
		cantor(start + sub_length*2, sub_length);
	}
}