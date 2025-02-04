import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 각 사람에게 인사할 때 소모되는 체력 배열
        int[] healthLoss = new int[N];
        // 각 사람에게 인사할 때 얻는 기쁨 배열
        int[] joyGain = new int[N];

        // 소모되는 체력 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            healthLoss[i] = Integer.parseInt(st.nextToken());
        }

        // 얻는 기쁨 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            joyGain[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 초기화
        int[][] dp = new int[N + 1][100];

        // DP 진행
        for (int i = 1; i <= N; i++) {
            int loss = healthLoss[i - 1];
            int gain = joyGain[i - 1];
            for (int j = 0; j < 100; j++) {
                if (j >= loss) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - loss] + gain);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 최대 기쁨 출력
        System.out.println(dp[N][99]);
    }
}
