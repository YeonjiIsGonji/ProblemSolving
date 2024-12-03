import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int D = Integer.parseInt(tk.nextToken());

        List<Node>[] graph = new ArrayList[D + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            graph[i].add(new Node(i + 1, 1));
        }

        //graph 생성
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            int dist = Integer.parseInt(tk.nextToken());

            if (v <= D) {
                graph[u].add(new Node(v, dist));
            }
        }

        //다익스트라 실행
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[D + 1];
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            int current = pq.poll().index;

            if (check[current]) {
                continue;
            };
            check[current] = true;

            for (Node next : graph[current]) { //{2, 1}, {50, 10}
                if (dist[next.index] > dist[current] + next.cost) {
                    dist[next.index] = dist[current] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        System.out.println(dist[D]);
    }
}
