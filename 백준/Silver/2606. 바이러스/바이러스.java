import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 세팅
        for (int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] visited = new int[N + 1];

        //그래프 순회
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            List<Integer> linkedNode = graph.get(currentNode);

            for (Integer nextNode : linkedNode) {
                if (visited[nextNode] == 0) {
                    queue.add(nextNode);
                    visited[nextNode] = 1;
                }
            }
        }

        // 컴퓨터 몇개 감염되었는지 확인
        int count = 0;
        for (int node : visited) {
            if (node == 1) {
                count++;
            }
        }

        // 1번 컴퓨터 제외
        System.out.println(count - 1);
    }
}
