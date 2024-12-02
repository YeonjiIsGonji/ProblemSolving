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
        int M = Integer.parseInt(tk.nextToken());
        int targetDist = Integer.parseInt(tk.nextToken());
        int start = Integer.parseInt(tk.nextToken());
        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //graph 생성
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            graph[u].add(new Node(v, 1));
        }

        //다익스트라 실행
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int current = pq.poll().index;

            if (check[current]) {
                continue;
            };
            check[current] = true;

            for (Node next : graph[current]) {
                if (dist[next.index] > dist[current] + next.cost) {
                    dist[next.index] = dist[current] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == targetDist) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            bw.write("-1");
            bw.flush();
            bw.close();
        } else {
            for (int i = 0; i < result.size(); i++) {
                bw.write(result.get(i).toString());
                if (i < result.size() - 1) {
                    bw.write("\n");
                }
            }
            bw.flush();
            bw.close();
        }
    }
}
