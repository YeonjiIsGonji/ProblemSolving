import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        int day = 0;

        if (N % 2 != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < N; i++) {
                if (stack.isEmpty()) {
                    stack.push(str[i]);
                } else {
                    String s = stack.peek();
                    if (s.equals("(") && str[i].equals(")") || s.equals(")") && str[i].equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(str[i]);
                    }
                }

                day = Math.max(day, stack.size());
            }

            if (!stack.isEmpty()) {
                day = -1;
            }

            System.out.println(day);
        }
    }
}
