import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 1. 입력 받기 N(그래프 크기), M(합계 횟수)
     * 2. for(N)
     *   2-1. String 입력
     *   2-2. for(N)
     *   2-3. graph 입력 & sum 입력
     *    sum[i][j] = sum[i][j - 1] + graph[i][j]
     * 3. for(M)
     *  3-1. String 입력 -> X1, Y1, X2, Y2
     *  3-2. 합계구하기 -> 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        long[][] graph = new long[N + 1][N + 1];
        long[][] sum = new long[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i + 1][j + 1] = Long.parseLong(input[j]);
                sum[i + 1][j + 1] = sum[i + 1][j] + graph[i + 1][j + 1];
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            if (x1 == x2 && y1 == y2) {
                System.out.println(graph[x1][y1]);
                continue;
            }
            long result = 0L;
            for (int j = x1; j <= x2; j++) {
                result += sum[j][y2] - sum[j][y1 - 1];
            }
            System.out.println(result);
        }
    }
}
