import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            for (int j = 0; j < input.length(); j++) {
                if (stack.size() > 0 && stack.peek() == input.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }
            if (stack.size() == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
