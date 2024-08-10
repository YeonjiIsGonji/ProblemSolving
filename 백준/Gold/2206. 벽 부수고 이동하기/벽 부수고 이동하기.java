import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        int[][] map = new int[N][M];
        int[][][] visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        // map 세팅
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            String row = tk.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }
        
        System.out.println(bfs(N, M, map, visited));

    }

    static int bfs(int N, int M, int[][] map, int[][][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));
        visited[0][0][0] = 1;

        while(!q.isEmpty()) {
            Pair curNode = q.poll();

            if (curNode.x == N - 1 && curNode.y == M - 1) {
                return visited[curNode.x][curNode.y][curNode.hammer];

            }
            for (int i = 0; i < 4; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY <M) {
                    // 다음 경로가 이동 가능한 경우
                    if (map[nextX][nextY] == 0 && visited[nextX][nextY][curNode.hammer] > visited[curNode.x][curNode.y][curNode.hammer] + 1) {
                        q.add(new Pair(nextX, nextY, curNode.hammer));
                        visited[nextX][nextY][curNode.hammer] = visited[curNode.x][curNode.y][curNode.hammer] + 1;
                    }
                    // 이동 불가능하고 벽을 부순적이 없는 경우
                    if (map[nextX][nextY] == 1 && curNode.hammer == 0) {
                        if (visited[nextX][nextY][curNode.hammer] > visited[curNode.x][curNode.y][curNode.hammer] + 1) {
                            visited[nextX][nextY][1] = visited[curNode.x][curNode.y][curNode.hammer] + 1;
                            q.add(new Pair(nextX, nextY, 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Pair {
        int x;
        int y;
        int hammer;

        public Pair(int x, int y, int hammer) {
            this.x = x;
            this.y = y;
            this.hammer = hammer;
        }
    }
}
