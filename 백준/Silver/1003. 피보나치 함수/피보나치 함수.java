import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[41][2];
        dp[0][0] = 1L;
        dp[0][1] = 0L;
        dp[1][0] = 0L;
        dp[1][1] = 1L;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}
