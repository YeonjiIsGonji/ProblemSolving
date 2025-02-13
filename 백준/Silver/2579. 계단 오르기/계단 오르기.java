import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] step = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = step[1];

        if (N >= 2) {
            dp[2] = step[1] + step[2];
        }

        for (int i = 3; i <= N ; i++) {
            // 1. 이전 단계에서 2계단 올라오기
            // 2. 이전 단계에서 1계단 올라오기(1계단을 올라오기 위해서는 전단계에서 2계단을 올라온 상태여야 함 = 0 + 2 + 1계단)
            dp[i] = Math.max(dp[i - 2] + step[i], dp[i - 3] + step[i - 1] + step[i]);
        }

        System.out.println(dp[N]);
    }
}
