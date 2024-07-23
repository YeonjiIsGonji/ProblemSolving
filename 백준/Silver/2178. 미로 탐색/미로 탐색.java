import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(tk.nextToken());
        int Y = Integer.parseInt(tk.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int[][] graph = new int[X][Y];
        int[][] visited = new int[X][Y];

        // 그래프 만들기
        for (int i = 0; i < X; i++) {
            String input = br.readLine();
            char[] arr = input.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                graph[i][j] = Character.getNumericValue(arr[j]);
            }
        }

        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        // 그래프 탐색
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int currX = currNode[0];
            int currY = currNode[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                // 유효한 범위 내에 있으며, 아직 방문하지 않았고 이동 가능한 경우
                if (nextX >= 0 && nextX < X && nextY >= 0 && nextY < Y && visited[nextX][nextY] == 0 && graph[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = visited[currX][currY] + 1;
                }
            }
        }
        // (N-1, M-1) 위치까지의 최소 거리를 출력
        System.out.println(visited[X - 1][Y - 1]);
    }
}
