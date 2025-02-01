import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dpA = new int[N + 1];
        int[] dpB = new int[N + 1];

        dpA[0] = 1;
        dpB[0] = 0;

        // DP 점화식
        for (int i = 1; i <= N; i++) {
            dpA[i] = dpB[i - 1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }

        System.out.println(dpA[N] + " " + dpB[N]);
    }
}
