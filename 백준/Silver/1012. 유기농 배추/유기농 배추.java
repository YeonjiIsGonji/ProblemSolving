import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tk;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(tk.nextToken());
            int N = Integer.parseInt(tk.nextToken());
            int K = Integer.parseInt(tk.nextToken());
            bfs (N, M, K);
        }
        bw.flush();
        bw.close();


    }

    static void bfs (int N, int M, int K) throws IOException {
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;

        for(int i = 0; i < K; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(tk.nextToken());
            int x = Integer.parseInt(tk.nextToken());
            if (0 <= x && x < N && 0 <= y && y < M) {
                map[x][y] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] curNode = q.poll();
                        int curX = curNode[0];
                        int curY = curNode[1];
                        for (int k = 0; k < 4; k++) {
                            int nextX = curX + dx[k];
                            int nextY = curY + dy[k];
                            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                                if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                                    q.add(new int[]{nextX,nextY});
                                    visited[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        bw.write(count + "\n");
    }
}
