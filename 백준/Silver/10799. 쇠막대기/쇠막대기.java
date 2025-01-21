import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                stack.push(input[i]);
            } else {
                if (input[i - 1] == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
