package week6;


import java.util.*;

public class Programmers_가장먼노드 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n + 1];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        //1. graph 만들기
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //2. graph 순회
        queue.add(1); //1번 노드에서 가장 먼 노드 개수 구하기
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int i = 0; i < graph.get(curNode).size(); i++) {
                int nextNode = graph.get(curNode).get(i);
                if (visited[nextNode] == 0) {
                    queue.add(nextNode);
                    visited[nextNode] = visited[curNode] + 1;
                }
            }
        }

        Arrays.sort(visited); //오름차순 정렬
        int max = visited[n]; //마지막 값이 가장 큰 값이므로 max 설정
        for (int i = n; i >= 0; i--) {
            if (max == visited[i]) {
                count++;
            } else if (max > visited[i]) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Programmers_가장먼노드 ex = new Programmers_가장먼노드();
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = ex.solution(n, edge);
        System.out.println(result);
    }
}

