import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M; //가로
    static int N; //세로

    static class Node implements Comparable<Node> {
        int x; //세로
        int y; //가로
        int day;

        public Node(int x, int y, int day) {
            this.day = day;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.day < o.day ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        boolean bfsPossible = false;

        List<int[]> ripeLocation = new ArrayList<>();

        int[][] visit = new int[N][M];
        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if (graph[i][j] == 1) {
                    ripeLocation.add(new int[]{i, j}); //j : 가로, i : 세로
                    //queue.offer(new int[]{j, i}); //j : 가로, i : 세로
                } else if (graph[i][j] == 0) {
                    bfsPossible = true;
                } else {
                    visit[i][j] = -1;
                }
            }
        }

        if (!bfsPossible) {
            System.out.println(0);
        } else {
            int day = bfs(graph, ripeLocation, visit);
            System.out.println(day);
        }

    }

    static int bfs(int[][] graph, List<int[]> ripeLocation, int[][] visit) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int[] location : ripeLocation) {
            pq.offer(new Node(location[0], location[1], 1));
            visit[location[0]][location[1]] = 1;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if (isValid(nextX, nextY) && visit[nextX][nextY] == 0 && graph[nextX][nextY] == 0) {
                    pq.offer(new Node(nextX, nextY, cur.day + 1));
                    visit[nextX][nextY] = cur.day + 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == 0) {
                    return -1;
                }
                count = Math.max(count, visit[i][j]);
            }
        }

        return count - 1; // 첫 시작은 원래 0일
    }

    static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
