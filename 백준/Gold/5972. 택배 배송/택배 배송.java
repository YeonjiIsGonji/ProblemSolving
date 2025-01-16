import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 1. 그래프 생성
     * 2. 다익스트라 실행
     * 3. dist[N] 출력
     */
    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.cost = cost;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());


        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        int cost = Dijkstra(1, N, graph);
        System.out.println(cost);
    }

    public static int Dijkstra(int start, int N, List<Node>[] graph) {
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int curNode = pq.poll().index;

            if (visit[curNode]) continue;
            visit[curNode] = true;

            for (Node next : graph[curNode]) {
                if (dist[next.index] > dist[curNode] + next.cost) {
                    dist[next.index] = dist[curNode] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[N];
    }

}
