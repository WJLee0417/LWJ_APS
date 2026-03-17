import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 속도가 훨씬 빠른 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());
        
        LinkedList<Character> editor = new LinkedList<>();
        for (char c : word.toCharArray()) {
            editor.add(c);
        }
        
        ListIterator<Character> iter = editor.listIterator(word.length());
        
        for (int i = 0; i < N; i++) {
            // 한 줄을 읽어와서 공백 기준으로 분리하기 위해 StringTokenizer 사용
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("L")) {
                if (iter.hasPrevious()) iter.previous();
            } else if (command.equals("D")) {
                if (iter.hasNext()) iter.next();
            } else if (command.equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (command.equals("P")) {
                // "P x" 형태이므로 두 번째 토큰을 가져와서 char로 변환
                char addChar = st.nextToken().charAt(0);
                iter.add(addChar);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : editor) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}