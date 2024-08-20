import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int[][][] graph = new int[N][M][2];
        List<int[]> room = new ArrayList<>();
        List<List<int[]>> wallArr = new ArrayList<>();
        List<int[]> comb = new ArrayList<>();
        List<int[]> virus = new ArrayList<>();
        int answer = 0;


        // 그래프 만들기 & 빈 방 위치 체크 & 바이러스 위치 체크
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j][0] = Integer.parseInt(tk.nextToken()); // 원본
                graph[i][j][1] = graph[i][j][0]; // 복제
                // 빈 방 체크
                if (graph[i][j][0] == 0) {
                    room.add(new int[]{i, j});
                } // 바이러스 체크
                else if (graph[i][j][0] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        // 3개 벽을 세우는 조합 만들기
        boolean[][] visited = new boolean[N][M];
        backtracking(N, M, room, wallArr, comb, visited, 0);


        for (int i = 0; i < wallArr.size(); i++) {
            List<int[]> r = wallArr.get(i);
            int count = 0;
            // 3개 벽 세우기
            for (int j = 0; j < 3; j++) {
                int x = r.get(j)[0];
                int y = r.get(j)[1];
                graph[x][y][1] = 1; // 벽 세우기
            }

            // 바이러스 확산
            bfs(N, M, virus, graph);

            // 안전 영역 크기 구하기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k][1] == 0) count++;
                    graph[j][k][1] = graph[j][k][0]; // 원본으로 복원하기
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }

    static void backtracking(int N, int M, List<int[]> room, List<List<int[]>> wallArr, List<int[]> comb, boolean[][] visited, int start) {
        if (comb.size() == 3) {
            wallArr.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < room.size(); i++) {
            int x = room.get(i)[0];
            int y = room.get(i)[1];
            if (0 <= x && x < N && 0 <= y && y < M) {
                if (!visited[x][y]) {
                    comb.add(room.get(i));
                    visited[x][y] = true;
                    backtracking(N, M, room, wallArr, comb, visited, i + 1);
                    visited[x][y] = false;
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }

    static void bfs (int N, int M, List<int[]> virus, int[][][] graph) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited2 = new boolean[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < virus.size(); i++) {
            int x = virus.get(i)[0];
            int y = virus.get(i)[1];
            if (!visited2[x][y]) {
                q.add(new int[]{x, y});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int j = 0; j < 4; j++) {
                        int nextX = cur[0] + dx[j];
                        int nextY = cur[1] + dy[j];

                        if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                            if (!visited2[nextX][nextY] && graph[nextX][nextY][1] != 1) {
                                q.add(new int[]{nextX,nextY});
                                visited2[nextX][nextY] = true;
                                graph[nextX][nextY][1] = 2; //바이러스 침투
                            }
                        }
                    }
                }
            }
        }
    }
}
