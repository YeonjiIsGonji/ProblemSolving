import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] graph;
    static int[][][] day;
    static Queue<int[]> start;
    static int H;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        int zeroTomatoCount = 0;
        start = new ArrayDeque<>();

        day = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(day[i][j], Integer.MAX_VALUE);
            }
        }

        graph = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(input[k]);
                    graph[i][j][k] = tomato;
                    if (tomato == 1) {
                        start.offer(new int[]{i, j, k});
                        day[i][j][k] = 0;
                    } else if (tomato == 0) {
                        zeroTomatoCount++;
                    } else {
                        day[i][j][k] = 0;
                    }
                }
            }
        }

        if (zeroTomatoCount == 0) {
            System.out.println("0");
            return;
        }

        bfs();
        int maxDay = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (maxDay == Integer.MAX_VALUE) {
                        System.out.println("-1");
                        return;
                    } else {
                        maxDay = Math.max(maxDay, day[i][j][k]);
                    }
                }
            }
        }

        System.out.println(maxDay);


    }

    public static void bfs() {
        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, -1, 1};

        while (!start.isEmpty()) {
            int[] node = start.poll();
            int curH = node[0];
            int curX = node[1];
            int curY = node[2];
            for (int i = 0; i < 6; i++) {
                int nextH = curH + dh[i];
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (0 <= nextH && nextH < H && 0 <= nextX && nextX < N && 0 <= nextY && nextY < M && graph[nextH][nextX][nextY] == 0) {
                    start.offer(new int[]{nextH, nextX, nextY});
                    day[nextH][nextX][nextY] = day[curH][curX][curY] + 1;
                    graph[nextH][nextX][nextY] = 1;
                }
            }
        }
    }
}
