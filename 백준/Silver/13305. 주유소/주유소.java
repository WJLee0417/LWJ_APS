import java.util.Scanner;

public class Main {
	static int N;			// 도시의 개수
	static long[] distance;	// 인접한 두 도시를 연결하는 도로의 길이 (최대 10억이므로 long)
	static long[] price;    // 주유소의 리터당 가격 (최대 10억이므로 long)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		distance = new long[N-1]; // 거리는 도시 개수보다 1개 적음
		price = new long[N];      // 주유소는 각 도시마다 있음
		
		// 1. 거리 정보 입력
		for(int i = 0; i < N-1; i++) {
			distance[i] = sc.nextLong();
		}
		
		// 2. 주유소 가격 정보 입력
		for(int i = 0; i < N; i++) {
			price[i] = sc.nextLong();
		}
		
		// 3. 그리디 알고리즘을 위한 변수 초기화
		long totalCost = 0;       // 최종 누적 비용 (최대 100조까지 갈 수 있으므로 반드시 long)
		long minCost = price[0];  // 현재까지 지나온 주유소 중 '가장 싼 가격' (일단 출발지 가격으로 세팅)
		
		// 4. 왼쪽 도시부터 오른쪽 도시로 이동 시작
		// (마지막 도시는 도착지이므로 기름을 넣을 필요가 없어 N-1 까지만 반복)
		for(int i = 0; i < N-1; i++) {
			
			// 이번에 도착한 도시의 기름값이 내가 아는 최저가(minCost)보다 더 싸다면?
			if(price[i] < minCost) {
				minCost = price[i]; // 최저가 갱신 (이제부터는 이 싼 가격으로 기름을 넣고 달린다)
			}
			
			// 다음 도시까지 가기 위해 필요한 기름을 '현재까지 발견한 가장 싼 가격(minCost)'으로 결제 누적
			totalCost += (minCost * distance[i]);
		}
		
		// 5. 최종 계산된 최소 비용 출력
		System.out.println(totalCost);
	}
}