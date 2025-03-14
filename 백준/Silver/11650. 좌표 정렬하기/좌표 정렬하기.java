import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i][0]) + " " + String.valueOf(arr[i][1]));
            bw.newLine();
        }

        bw.flush();
    }
}
