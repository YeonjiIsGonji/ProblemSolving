import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][N];
        List<Integer> homes = new ArrayList<>();
        char[][] graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == '1' && !visited[i][j]) {
                    int homeCount = bfs(graph, visited, i, j, N);
                    homes.add(homeCount);
                }
            }
        }

        homes.sort(Comparator.naturalOrder());

        bw.write(String.valueOf(homes.size()));
        bw.newLine();
        for (int i = 0; i < homes.size(); i++) {
            bw.write(String.valueOf(homes.get(i)));
            if (i < homes.size() - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static int bfs(char[][] graph, boolean[][] visited, int x, int y, int N) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int homeCount = 0;

        q.offer(new int[]{x, y});
        visited[x][y] = true;
        homeCount++;

        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int curX = curNode[0];
            int curY = curNode[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                    if (!visited[nextX][nextY] && graph[nextX][nextY] == '1') {
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        homeCount++;
                    }
                }
            }
        }
        return homeCount;
    }
}
