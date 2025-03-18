import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        if (K > M) {
            System.out.println(0);
            return;
        }
        
        int total = 0;

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            int[] arr = new int[M];

            for (int j = 0; j < M; j++) {
                arr[j] = row.charAt(j) - '0';
            }

            total += check(arr, K, M);
        }

        System.out.println(total);
    }

    static int check(int[] arr, int K, int M) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        if (sum == 0) {
            count++;
        }

        for (int i = K; i < M; i++) {
            sum = sum + arr[i] - arr[i - K];
            if (sum == 0) {
                count++;
            }
        }

        return count;
    }
}
