import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int div = 10007;

        int[] dp = new int[1000];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i < N; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2 )%div)%div;
        }

        System.out.println(dp[N - 1]);
    }
}
