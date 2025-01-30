import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count = 0;
        System.out.println(coinCount(N));
    }

    public static int coinCount(int n) {
        if (n == 0) {
            return count;
        } else if (n == 1) {
            return -1;
        }

        if (n % 5 == 0) {
            ++count;
            return coinCount(n - 5);
        } else {
            ++count;
            return coinCount(n - 2);
        }
    }
}
