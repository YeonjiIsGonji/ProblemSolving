import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] material = new int[N];
        int sum = 0;
        int count = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            material[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(material);

        int left = 0;
        int right = left + 1;

        while (left < N - 1) {
            sum = material[left] + material[right];
            if (sum == M) {
                count++;
                left++;
                right = left + 1;
            } else if (sum > M) {
                left++;
                right = left + 1;
            } else {
                if (right == N - 1) {
                    left++;
                    right = left + 1;
                    continue;
                }
                right++;
            }
        }

        System.out.println(count);
    }
}
