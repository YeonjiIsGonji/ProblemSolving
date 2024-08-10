import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];

        int N = Integer.parseInt(tk.nextToken());
        int target = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < 100001; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        q.add(N);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == target) {
                break;
            }
            int next1 = cur + 1;
            int next2 = cur - 1;
            int next3 = cur * 2;
            int next4 = - (cur * 2);
            int[] dir = {next1, next2, next3, next4};

            for (int i = 0; i < 4; i++) {
                int next = dir[i];
                if (0 <= next && next <= 100000) {
                    if(visited[next] > visited[cur] + 1) {
                        visited[next] = visited[cur] + 1;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(visited[target]);
    }
}
