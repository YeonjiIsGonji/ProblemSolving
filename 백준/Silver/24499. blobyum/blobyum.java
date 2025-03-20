import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] pie = new int[N];
        String[] array = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            pie[i] = Integer.parseInt(array[i]);
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += pie[i];
        }

        int max = sum;

        for (int i = 1; i < N; i++) {
            sum = sum - pie[i - 1] + pie[(i + K - 1) % N];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
