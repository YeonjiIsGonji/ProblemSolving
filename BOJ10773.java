package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= K ; i++) {
            int N = Integer.parseInt((br.readLine()));
            if (N != 0) {
                stack.push(N);
            } else {
                stack.pop();
            }
        }
        if (stack.empty() == true) {
            System.out.println(0);
        }else {
            int sum = 0;
            int M = stack.size();
            for (int i = 0; i < M; i++) { //i = 0,1
                int num = stack.pop();
                sum += num;

            }
            System.out.println(sum);
        }
    }
}
