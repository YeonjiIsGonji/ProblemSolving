import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] graph;
    static int[][][] day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        graph = new int[H][N][M];
        day = new int[H][N][M];

        int zeroCount = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    graph[h][i][j] = Integer.parseInt(input[j]);
                    if (graph[h][i][j] == 0) {
                        zeroCount++;
                    } else if (graph[h][i][j] == 1) {
                        q.offer(new int[]{h, i, j});
                    }
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        bfs(q);

        int maxDay = 0;

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        maxDay = Math.max(maxDay, day[h][i][j]);
                    }
                }
            }

        }
        System.out.println(maxDay);
    }

    public static void bfs(Queue<int[]> q) {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int curZ = curNode[0];
            int curX = curNode[1];
            int curY = curNode[2];

            for (int i = 0; i < 6; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextZ = curZ + dz[i];

                if (0<= nextZ && nextZ < H && 0 <= nextX && nextX < N && 0 <= nextY && nextY < M && graph[nextZ][nextX][nextY] == 0) {
                    day[nextZ][nextX][nextY] = day[curZ][curX][curY] + 1;
                    graph[nextZ][nextX][nextY] = 1;
                    q.offer(new int[]{nextZ, nextX, nextY});
                }
            }
        }
    }
}
