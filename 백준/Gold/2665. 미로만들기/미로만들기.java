import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    /**
     * 1. 그래프 입력
     * 2. 다익스트라 실행
     *  방 1 - 방 1 : cost = 0, 방 1 - 방 0 : cost = 1
     * 3. dist[N-1][N-1] 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        int changeRoom = Dijkstra(graph, N);

        System.out.println(changeRoom);
    }

    public static int Dijkstra(int[][] graph, int N) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        boolean[][] visit = new boolean[N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        if (graph[0][0] == 1) {
            dist[0][0] = 0;
        } else {
            dist[0][0] = 1;
        }

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                    if (graph[nextX][nextY] == 1) {
                        if (dist[nextX][nextY] > dist[curX][curY] + 0) {
                            dist[nextX][nextY] = dist[curX][curY];
                            q.offer(new int[]{nextX, nextY});
                        }
                    } else if (graph[nextX][nextY] == 0) {
                        if (dist[nextX][nextY] > dist[curX][curY] + 1) {
                            dist[nextX][nextY] = dist[curX][curY] + 1;
                            q.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}
