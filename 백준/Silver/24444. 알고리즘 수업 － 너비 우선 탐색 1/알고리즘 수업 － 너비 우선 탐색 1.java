
import java.io.*;
import java.util.*;

public class Main {
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
        int[] visitied = new int[N+1]; // N번 노드에 몇번째 방문했는지 확인

        queue.add(R);
        int order = 1;
        visitied[R] = order;
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            for (Integer i : graph.get(currentNode)) {
                if (visitied[i] == 0) {
                    queue.add(i);
                    visitied[i] = ++order;
                }

            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(visitied[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
