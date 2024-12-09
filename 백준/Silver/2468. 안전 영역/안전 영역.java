import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * 1. N, graph 입력 받기 - 최소 높이, 최대 높이 구하기
 * 2. 최소 높이 ~ (최대 높이 - 1) 까지 각 case별 BFS 구하기
 *  2-1. 그래프 전체 순회하며 BFS로 안전 영역 개수 구하기
 * 3. 안전 영역 최대 값 출력
 */
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int minH = Integer.MAX_VALUE;
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] height = input.split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(height[j]);
                minH = Math.min(minH, graph[i][j]);
                maxH = Math.max(maxH, graph[i][j]);
            }
        }
        
        int maxSafeZone = 1; // 비가 오지 않을 경우 최소 1개
        
        for (int i = minH; i < maxH; i++) {
            int safeZone = BFS(i, graph);
            maxSafeZone = Math.max(maxSafeZone, safeZone);
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
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = cur[0] + dx[k];
                            int nextY = cur[1] + dy[k];
                            if (isValid(nextX, nextY)) {
                                if (graph[nextX][nextY] > height && !visit[nextX][nextY]) {
                                    queue.offer(new int[]{nextX, nextY});
                                    visit[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
