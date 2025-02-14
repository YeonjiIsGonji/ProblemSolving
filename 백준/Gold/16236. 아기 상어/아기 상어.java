import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[][] graph;
    static int N;
    static int sharkSize;
    static int eatFish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int oneSizeCount = 0;
        graph = new int[N][N];
        int[] cur = null;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if (graph[i][j] == 1) {
                    oneSizeCount++;
                } else if (graph[i][j] == 9) {
                    cur = new int[]{i, j};
                    graph[i][j] = 0;
                }
            }
        }

        if (oneSizeCount == 0) {
            System.out.println("0");
            return;
        }

        sharkSize = 2;
        eatFish = 0;
        int move = 0;

        int[] dx = {-1, 0, 0, 1}; // 행
        int[] dy = {0, -1, 1, 0}; // 열


        while (true) {
            //[0] = x(행), [1] = y(열), [2] = move
            //1. move 가 가장 짧은 것 먼저
            //2. 가장 가까운 행(x) 먼저 = 가장 위에 있는 물고기 먼저
            //3. 행이 똑같다면, 가장 왼쪽(y)에 있는 물고기 먼저
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));

            boolean[][] visit = new boolean[N][N];

            pq.offer(new int[]{cur[0], cur[1], 0});
            visit[cur[0]][cur[1]] = true;

            boolean eatCheck = false; //상어가 먹이를 먹었는지 체크

            while (!pq.isEmpty()) {
                cur = pq.poll();
                int curX = cur[0];
                int curY = cur[1];

                if (graph[curX][curY] != 0 && graph[curX][curY] < sharkSize) {
                    graph[curX][curY] = 0;
                    eatFish++;
                    move += cur[2];
                    eatCheck = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visit[nextX][nextY] || graph[nextX][nextY] > sharkSize) {
                        continue;
                    }

                    pq.offer(new int[]{nextX, nextY, cur[2] + 1});
                    visit[nextX][nextY] = true;
                }
            }

            if (!eatCheck) {
                break;
            }

            if (sharkSize == eatFish) {
                sharkSize++;
                eatFish = 0;
            }
        }

        System.out.println(move);
    }

}
