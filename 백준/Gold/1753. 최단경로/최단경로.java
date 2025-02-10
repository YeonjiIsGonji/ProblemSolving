import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? - 1 : 1;
        }
    }

    static List<Node>[] graph;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph[u].add(new Node(v, w));
        }

        Dijkstra(V, start);
        for (int i = 1; i <= V; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                bw.write("INF");
            } else {
                bw.write(String.valueOf(cost[i]));
            }
            if (i < V) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static void Dijkstra(int V, int start) {
        cost = new int[V +1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Node next : graph[curNode.index]) {
                int nextCost = cost[curNode.index] + next.cost;
                if (nextCost < cost[next.index]) {
                    cost[next.index] = nextCost;
                    pq.offer(new Node(next.index, nextCost));
                }
            }
        }
    }
}
