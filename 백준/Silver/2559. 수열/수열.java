import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] temp = new int[N + 1];
        int[] sum = new int[N + 1];

        input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            temp[i] = Integer.parseInt(input[i - 1]);
            sum[i] += sum[i - 1] + temp[i];
        }

        int left = 0;
        int right = left + K;
        int max = -10000000;;
        while (right <= N) {
            max = Math.max(sum[right] - sum[left], max);
            left++;
            right = left + K;
        }

        System.out.println(max);
    }
}
