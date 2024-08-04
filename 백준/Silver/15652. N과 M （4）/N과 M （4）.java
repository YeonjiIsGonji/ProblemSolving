import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        int[] num = new int[N];
        int[] arr = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        backtracking(num, arr, 0, 0);
        bw.flush();
    }

    static void backtracking(int[]num, int[]arr, int numIndex, int arrIndex) throws IOException {
        if (arrIndex == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = numIndex; i < num.length; i++) {
            arr[arrIndex] = num[i];
            backtracking(num, arr, i, arrIndex + 1);
        }
    }
}
