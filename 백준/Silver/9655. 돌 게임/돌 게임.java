import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        game(N);
        if (count % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

    public static void game(int N) {
        if (N == 1 || N == 0) {
            count++;
            return;
        }

        if (N > 3) {
            count++;
            game(N - 3);
        } else {
            count++;
            game(N - 1);
        }
    }
}
