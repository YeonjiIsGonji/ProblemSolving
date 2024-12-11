import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            graph[u].add(new Node(v, dist));
            graph[v].add(new Node(u, dist));
        }

        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        // 1-> v1 -> v2 -> N
        int sum1 = 0;
        int[] order = new int[]{1, v1, v2, N};
        for (int i = 0; i < 3; i++) {
            int dist = Dijkstra(graph, order[i], order[i + 1]);
            if (dist == -1) {
                sum1 = -1;
                break;
            } else {
                sum1 += dist;
            }
        }

        // 1-> v2 -> v1 -> N
        int sum2 = 0;
        int[] order2 = new int[]{1, v2, v1, N};
        for (int i = 0; i < 3; i++) {
            int dist = Dijkstra(graph, order2[i], order2[i + 1]);
            if (dist == -1) {
                sum2 = -1;
                break;
            } else {
                sum2 += dist;
            }
        }

        int min = -1;
        if (sum1 != -1 && sum2 != -1) {
            min = Math.min(sum1, sum2);
        } else if (sum1 == -1) {
            min = sum2;
        } else if (sum2 == -1) {
            min = sum1;
        }
        System.out.println(min);
    }

    public static int Dijkstra(List<Node>[] graph, int start, int target) {
        int[] dist = new int[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 처리된 거리보다 크면 스킵
            if (cur.cost > dist[cur.node]) {
                continue;
            }

            for (Node next : graph[cur.node]) {
                int cost = cur.cost + next.cost;
                if (cost < dist[next.node]) {
                    dist[next.node] = cost;
                    pq.offer(new Node(next.node, cost));
                }
            }
        }

        if (dist[target] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[target];
    }
}
