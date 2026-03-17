import java.util.Scanner;

public class Main {
	static int N;
	static int[] numbers;
	static int[] operators;
	static int maxVal;
	static int minVal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		operators = new int[4];
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		for(int j = 0; j < 4; j++) {
			operators[j] = sc.nextInt();
		}
		
		cal(1, numbers[0]);
		System.out.println(maxVal);
		System.out.println(minVal);
	}
	
	static void cal(int depth, int curVal) {
		if(depth == N) {
			maxVal = Math.max(maxVal, curVal);
			minVal = Math.min(minVal, curVal);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operators[i] > 0) {
				operators[i]--;
				int nextVal = 0;
				
				if(i == 0) nextVal = curVal + numbers[depth];
				if(i == 1) nextVal = curVal - numbers[depth];
				if(i == 2) nextVal = curVal * numbers[depth];
				if(i == 3) nextVal = curVal / numbers[depth];
			
				cal(depth+1, nextVal);
				operators[i]++;
			}
		}
	}
}
