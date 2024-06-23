package BAEKJOON;

import java.io.*;
import java.util.*;

public class BOJ24444 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        int N, M, R;
        int u, v;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        R = Integer.parseInt(tk.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(tk.nextToken());
            v = Integer.parseInt(tk.nextToken());

            // 그래프 세팅
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        // BFS 탐색
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N + 1]; // visited[1] 1번노드에 몇 번 만에 방문했는지
        int count = 1;

        q.add(R);
        visited[R] = count;

        while (!q.isEmpty()) {
            Integer currentNode = q.poll();

            ArrayList<Integer> linkedNode = graph.get(currentNode);
            for (Integer nextNode : linkedNode) {
                if (visited[nextNode] == 0) {
                    // 추가탐색
                    q.add(nextNode);
                    visited[nextNode] = ++count;
                }
            }
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(visited[i] + "\n");
        }
        bw.flush();
    }
}
