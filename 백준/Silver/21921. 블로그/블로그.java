import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] visit = new int[N];
        for (int i = 0; i < N; i++) {
            visit[i] = Integer.parseInt(input[i]);
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visit[i];
        }

        int max = sum;
        int maxCount = 1;

        for (int i = X; i < N; i++) {
            sum += visit[i] - visit[i - X];
            if (max == sum) {
                maxCount++;
            } else if (max < sum) {
                max = sum;
                maxCount = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(maxCount);
    }
}
