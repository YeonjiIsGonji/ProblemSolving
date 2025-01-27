import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tk.nextToken());
            int M = Integer.parseInt(tk.nextToken());

            dp = new int[M + 1][N + 1];
            int result = combination(M, N);
            bw.write(result + "\n");
        }
        bw.flush();

    }
    public static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
