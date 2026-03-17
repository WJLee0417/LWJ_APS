import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static List<int[]> emptyCells;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		emptyCells = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) {
					emptyCells.add(new int[] {i,j});
				}
			}
		}
		
		sudoku(0);
	}
	
	static void sudoku(int depth) {
		if(depth == emptyCells.size()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int nr = emptyCells.get(depth)[0];
		int nc = emptyCells.get(depth)[1];
		
		for(int num = 1; num <= 9; num++) {
			if(isValid(nr, nc, num)) {
				map[nr][nc] = num;
				sudoku(depth+1);
				map[nr][nc] = 0;
			}
		}
	}
	
	static boolean isValid(int r, int c, int num) {
		for(int i = 0; i < 9; i++) {
			if(map[r][i] == num) return false;
		}
		
		for(int i = 0; i < 9; i++) {
			if(map[i][c] == num) return false;
		}
		
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		for(int i = sr; i <= sr+2; i++) {
			for(int j = sc; j <= sc+2; j++) {
				if(map[i][j] == num) return false;
			}
		}
		
		return true;
	}
}