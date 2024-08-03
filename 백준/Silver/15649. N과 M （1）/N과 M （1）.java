import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        // 1. numbs 만들기
        int[] numbs = new int[N];
        int[] arr = new int[M];
        boolean[] visited = new boolean[N];

        //List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbs[i] = i + 1;
        }

        backtracking(numbs, arr, visited, M, 0);
    }

    private static void backtracking(int[] numbs, int[] arr, boolean[] visited, int M, int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < numbs.length; i++) {
            // numbs[i] 를 넣을 수 있으면 넣고 백트레킹
            if (visited[i] == false) {
                visited[i] = true;
                arr[index] = numbs[i];

                backtracking(numbs, arr, visited, M, index + 1);

                arr[index] = 0;
                visited[i] = false;
            }
        }

    }


}
