import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1. 입력 받기 N, M, input
     * int[] num, int[] sum
     * 2. for(i = 1 <= n) {
     *  2-1. num, sum 입력
     *  2-2. sum[] % M == 0 -> count++;
     * }
     * 3. sum[] % M이 같은 것들 중 2개를 뽑는 경우의 수 count에 더하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        long[] num = new long[N + 1];
        long[] sum = new long[N + 1];
        long[] remainderCount = new long[M];
        long count = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            num[i] = Long.parseLong(input[i - 1]);
            sum[i] = sum[i - 1] + num[i];
            int remainder = (int) (sum[i] % M);
            if (remainder == 0) {
                count++;
            }
            remainderCount[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (remainderCount[i] > 1) {
                count = count + (remainderCount[i] * (remainderCount[i] - 1) / 2);
            }
        }

        System.out.println(count);
    }
}
