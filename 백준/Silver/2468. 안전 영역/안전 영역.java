import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int minH = Integer.MAX_VALUE;
        int maxH = 0;

        for (int i = 0; i < N; i++) {
            String[] height = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(height[j]);
                minH = Math.min(minH, graph[i][j]);
                maxH = Math.max(maxH, graph[i][j]);
            }
        }

        int maxSafeZone = 0;
        for (int i = minH - 1; i <= maxH; i++) { // 비가 오지 않는 경우도 포함
            maxSafeZone = Math.max(maxSafeZone, BFS(i, graph));
        }
        System.out.println(maxSafeZone);
    }

    private static int BFS(int height, int[][] graph) {
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] > height && !visit[i][j]) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true; // 방문 처리
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = cur[0] + dx[k];
                            int nextY = cur[1] + dy[k];
                            if (isValid(nextX, nextY, height, graph, visit)) {
                                queue.offer(new int[]{nextX, nextY});
                                visit[nextX][nextY] = true; // 방문 처리
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValid(int x, int y, int height, int[][] graph, boolean[][] visit) {
        return 0 <= x && x < N && 0 <= y && y < N && graph[x][y] > height && !visit[x][y];
    }
}
