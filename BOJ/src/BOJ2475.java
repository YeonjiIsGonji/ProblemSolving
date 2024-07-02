import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int sum = 0;

        while (tk.hasMoreTokens()) {
            int number = Integer.parseInt(tk.nextToken());
            sum += number * number;
        }

        System.out.println(sum % 10);
    }
}
