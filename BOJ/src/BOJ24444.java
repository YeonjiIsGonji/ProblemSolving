
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int R = Integer.parseInt(tk.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int u, v;

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // graph 만들기
        for(int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(tk.nextToken());
            v = Integer.parseInt(tk.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //오름차순 정렬
        for (ArrayList<Integer> i : graph) {
            i.sort(Comparator.naturalOrder());
        }

        // BFS 탐색
        Queue<Integer> queue = new LinkedList<>();
        //ArrayList<Integer> visited = new ArrayList<>();
        int[] visitied = new int[N+1]; //0으로 세팅

        queue.add(R);
        visitied[R] = 1;
        int order = 1;
        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            for (Integer i : graph.get(next)) {
                if (visitied[i] == 0) {
                    queue.add(i);
                    visitied[i] = ++order;
                }

            }
        }

        int[] result = new int[N+1];
        for (int i = 1; i <= N + 1; i++) {
            result[i]0 = visited.indexOf(i) + 1;
            System.out.println(result[i]);
        }

    }
}
