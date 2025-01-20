import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    /**
     * 1. BFS 탐색
     *  1-1. R / B / G 인 경우
     *  1-2. R = G / B 인 경우
     * 2. 1-1, 1-2 값 출력
     */
    public static class Node {
        public int x;
        public int y;
        public char color;

        public Node(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int RGB = 0;
        int RB = 0;

        char[][] graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input[j];
            }
        }

        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;
                BFS(graph, N, i, j, visit, true);
                RGB++;
            }
        }

        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;
                BFS(graph, N, i, j, visit, false);
                RB++;
            }
        }

        System.out.println(RGB + " " + RB);
    }

    public static void BFS(char[][] graph, int N, int x, int y, boolean[][] visit, boolean RGB) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        //int count = 0;

        Queue<Node> q = new ArrayDeque();
        q.offer(new Node(x, y, graph[x][y]));
        visit[x][y] = true;
        //count++;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visit[nextX][nextY]) {
                    char nextColor = graph[nextX][nextY];
                    // not 적록색약
                    if (RGB) {
                        countRGB(visit, curNode, nextColor, q, nextX, nextY);
                    } else {
                        countRB(visit, curNode, nextColor, q, nextX, nextY);
                    }
                }
            }
        }

    }

    private static void countRGB(boolean[][] visit, Node curNode, char nextColor, Queue<Node> q, int nextX, int nextY) {
        if (curNode.color == nextColor) {
            q.offer(new Node(nextX, nextY, nextColor));
            visit[nextX][nextY] = true;
        }
    }

    private static void countRB(boolean[][] visit, Node curNode, char nextColor, Queue<Node> q, int nextX, int nextY) {
        if (curNode.color == 'R' && (nextColor == 'R' || nextColor == 'G')) {
            q.offer(new Node(nextX, nextY, nextColor));
            visit[nextX][nextY] = true;
        } else if (curNode.color == 'G' && (nextColor == 'G' || nextColor == 'R')) {
            q.offer(new Node(nextX, nextY, nextColor));
            visit[nextX][nextY] = true;
        } else if (curNode.color == nextColor) {
            q.offer(new Node(nextX, nextY, nextColor));
            visit[nextX][nextY] = true;
        }
    }
}
