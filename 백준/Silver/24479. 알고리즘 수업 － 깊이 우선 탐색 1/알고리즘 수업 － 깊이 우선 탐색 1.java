import java.io.*;
import java.util.*;

public class Main {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, List<Integer>> graph = new HashMap<>();

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int start = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (graph.containsKey(i)) {
                graph.get(i).sort(Comparator.naturalOrder());
            }
        }

        boolean[] visited = new boolean[N + 1];
        Map<Integer, Integer> visitOrder = new HashMap<>();

        dfs(start, graph, visited, visitOrder);

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(visitOrder.getOrDefault(i, 0)));
            if (i < N) {
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited, Map<Integer, Integer> visitOrder) {
        visited[start] = true;
        visitOrder.put(start, count++);

        List<Integer> neighbors = graph.getOrDefault(start, Collections.emptyList());
        for (Integer node : neighbors) {
            if (!visited[node]) {
                dfs(node, graph, visited, visitOrder);
            }
        }
    }
}

