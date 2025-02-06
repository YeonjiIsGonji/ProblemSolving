import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= X; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(Math.min(1 + dp[i / 2], 1 + dp[i / 3]), 1 + dp[i - 2]);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(1 + dp[i / 2], 1 + dp[i - 1]);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(1 + dp[i / 3], 1 + dp[i - 1]);
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        System.out.println(dp[X]);
    }
}
