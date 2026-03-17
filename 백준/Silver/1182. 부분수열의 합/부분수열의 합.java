
import java.util.Scanner;

// 부분수열의 합
/**
 * N개의 정수로 이루어진 수열이 있을 때, 
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */

public class Main {
	static int N, S, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 탐색 시작(현재 인덱스 0, 현재까지의 합: 0)
		dfs(0, 0);
		
		// 문제 조건 "크기가 양수인 부분수열" (즉, 공집합 제외)
		// 타깃 S가 0일 경우, 아무것도 선택하지 않은 합(0)도 카운트되므로 1을 빼준다.
		if (S == 0) {
			ans--;
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int depth, int sum) {
		
		// 1. 종료 조건
		if(depth == N) {
			if(sum == S) {
				ans++;
			}
			return;
		}
		
		// 2&3. 선택 및 깊이 탐색
		
		// 루트 A: 현재 위치(depth)의 숫자를 더하고 다음으로 넘어간다.
		dfs(depth+1, sum+arr[depth]);
		
		// 루트 B: 현재 위치(depth)의 숫자를 더하지 않고 다음으로 넘어간다.
		dfs(depth+1, sum);
	}
}
