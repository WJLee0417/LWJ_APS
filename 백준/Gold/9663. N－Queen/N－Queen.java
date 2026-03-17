import java.util.Scanner;

public class Main {
	static int N, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N];
		ans = 0;
		
		// 0번째 행부터 퀸을 놓기 시작
		dfs(0);
		
		System.out.println(ans);
	}
	
	static void dfs(int row) {
		// 1. 종료 조건 - N개의 퀸을 모두 무사히 배치했다면
		if (row == N) {
			ans++;
			return;
		}
		
		// 2. 현재 행(row)에서 0열부터 N-1열까지 하나씩 퀸을 놓아본다.
		for(int col = 0; col < N; col++) {
			
			arr[row] = col; // 일단 퀸을 놓는다. (상태 변경)
			
			// 3. 가지치기 - 방금 놓은 퀸이 안전한 자리인지 검사한다.
			if(isValid(row)) {
				// 안전하다면 다음 줄로 넘어간다.
				dfs(row + 1);
			}
			// 안전하지 않다면 dfs(row+1)을 호출하지 않는다. (이게 백트래킹의 핵심!)
			// for문이 돌아가면서 arr[row]에 새로운 col 값이 덮어씌워지므로,
			// 굳이 arr[row] = 0처럼 상태 복구를 명시할 필요가 없다.
		}
	}
	
	// 현재 행(row)에 놓은 퀸이 위쪽 퀸들에게 공격받지 않는지 검사하는 함수
	static boolean isValid(int row) {
		// 0번째 행부터 현재 행 바로 윗줄(row - 1)까지만 검사하면 된다.
		for (int i = 0; i < row; i++) {
			
			// 조건 1. 같은 열에 다른 퀸이 존재하는가?
			if (arr[row] == arr[i]) {
				return false;
			}
			
			// 조건 2. 대각선에 다른 퀸이 존재하는가?
			// (행의 차이의 절댓값과 열의 차이의 절댓값이 같으면 대각선 상에 있는 것)
			if(Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
				return false;
			}
		}
		return true; // 무사통과!
	}
}
