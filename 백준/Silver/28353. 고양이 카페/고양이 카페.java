import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] cat = new int[N];
        for (int i = 0; i < N; i++) {
            cat[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(cat);
        int left = 0;
        int right = N - 1;
        int count = 0;
        
        while (left < right) {
            int weight = cat[left] + cat[right];
            if (weight > K) {
                right--;
            } else if (weight <= K) {
                count++;
                left++;
                right--;
            }
        }

        System.out.println(count);
    }
}
