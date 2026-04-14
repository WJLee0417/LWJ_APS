import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line = br.readLine()) != null) {
			if(line.trim().isEmpty()) break;
			
			int x = Integer.parseInt(line.trim()) * 10000000;
			int n = Integer.parseInt(br.readLine().trim());
			
			int[] legos = new int[n];
			
			for(int i = 0; i < n; i++) {
				legos[i] = Integer.parseInt(br.readLine().trim());
			}
			
			Arrays.sort(legos);
			
			int left = 0;
			int right = n - 1;
			boolean flag = false;
			
			while(left < right) {
				int sum = legos[left] + legos[right];
				if(sum == x) {
					System.out.println("yes "+legos[left]+" "+legos[right]);
					flag = true;
					break;
				}
				else if(sum < x) {
					left++;
				}
				else if(sum > x) {
					right--;
				}
			}
			
			if(flag == false) {
				System.out.println("danger");
			}
		}
	}
}
