import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] timeTable = new int[N][2];
		for(int i = 0; i < N; i++) {
			timeTable[i][0] = sc.nextInt();
			timeTable[i][1] = sc.nextInt();
		}
		
		Arrays.sort(timeTable, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		
		int count = 0;
		int prevEndTime = 0;
		
		for(int i = 0; i < N; i++) {
			if(timeTable[i][0] >= prevEndTime) {
				count++;
				prevEndTime = timeTable[i][1];
			}
		}
		
		System.out.println(count);
	}
}