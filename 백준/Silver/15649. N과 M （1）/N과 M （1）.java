import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //BOJ15649
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int[] num = new int[N];
        int[] arr = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        backtracking(num, arr, 0);
        bw.flush();
    }

    static void backtracking(int[]num, int[] arr, int arrIndex) throws IOException {
        if (arrIndex == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[arrIndex] = num[i];
                backtracking(num, arr, arrIndex + 1);
                visited[i] = false;
            }
        }
    }
}
