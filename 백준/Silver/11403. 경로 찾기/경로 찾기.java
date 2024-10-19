import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1. graph 행렬 만들기, int N = node 개수
     * 2. 다익스트라 실행 for문(start = 1 ~ N)
     *  2-1. dist[Node] = 0, boolean check[Node]
     *  2-2. 출발지 Node(입력값) = start, pq = {0,start}
     *  2-3. pq에서 꺼낸 노드 cur, if (grpah[cur][i] = 1) => dist[i] = dist[cur] + 1, pq 추가
     *  2-3. dist 값이 0보다 큰 경우(방문할 수 있음을 의미) 1 출력, 그 외는 0출력
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        // 다익스트라 실행
        for (int i = 1; i <= N; i++) {
            Dijkstra(N, i, graph);
            if (i < N) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void Dijkstra(int N, int start, int[][] graph) throws IOException {

        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, start));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (check[curNode.index]) continue;
            check[curNode.index] = true;

            // 연결된 node 비교
            for (int i = 1; i <= N; i++) {
                if (graph[curNode.index][i] == 1) {
                    int newCost = curNode.cost + 1;
                    if (newCost > dist[i]) {
                        dist[i] = newCost;
                        pq.add(new Node(newCost, i));
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dist[i] > 0) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }
        }

    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
