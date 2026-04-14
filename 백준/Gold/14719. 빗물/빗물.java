import java.util.Scanner;

public class Main {
	static int H;
	static int W;
	static int[] blocks;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		blocks = new int[W];
		
		for(int i = 0; i < W; i++) {
			blocks[i] = sc.nextInt();
		}
		
		int total_water = 0;
		
		for(int i = 1; i < W-1; i++) {
			int left_max = 0;
			int right_max = 0;
			
			for(int j = 0; j < i; j++) {
				left_max = Math.max(left_max, blocks[j]);
			}
			
			for(int j = i+1; j < W; j++) {
				right_max = Math.max(right_max, blocks[j]);
			}
			
			int limit = Math.min(left_max, right_max);
			
			if(limit > blocks[i]) {
				total_water += (limit - blocks[i]);
			}
		}
		
		System.out.println(total_water);
	}
}
