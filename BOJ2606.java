package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] network = new int[N+1][N+1];


        //행렬 만들기
        for (int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(tk.nextToken());
            int com2 = Integer.parseInt(tk.nextToken());
            network[com1][com2] = 1; // 연결된 컴퓨터 1
            network[com2][com1] = 1;
        }

        //BFS 탐색
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N+1];

        queue.add(1);
        visited[1] = 1;
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            for (int i = 1; i < N + 1; i++) {
                if (network[currentNode][i] == 1 && visited[i] == 0) {
                    //추가탐색
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }

        // 바이러스 컴퓨터 수 구하기
        int virusCount = 0;
        for (int com : visited) {
            if (com == 1) {
                virusCount++;
            }
        }
        System.out.println(virusCount - 1); //1번 컴퓨터 제외

    }
}
