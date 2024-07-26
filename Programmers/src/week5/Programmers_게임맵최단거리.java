package week5;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_게임맵최단거리 {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();
            // 현재 노드가 n, m에 도달하면 visited[n-1][m-1] 리턴
            if (currNode[0] == maps.length - 1 && currNode[1] == maps[0].length -1 ) {
                return visited[currNode[0]][currNode[1]];
            }
            // nextNode 확인
            for (int i = 0; i < dx.length; i++) {
                int n = currNode[0] + dx[i]; // 좌, 우 이동
                int m = currNode[1] + dy[i]; // 상, 하 이동
                if (0 <= n && n < maps.length && 0 <= m && m < maps[0].length) {
                    if (visited[n][m] == 0 && maps[n][m] == 1) {
                        // visited에 몇 번째 방문했는지 입력. currNode에서 한 칸 이동한 값이 nextNode의 방문 차례
                        // 이렇게해야 길이 나뉠 때 동일한 방문 순서가 입력된다.
                        visited[n][m] = visited[currNode[0]][currNode[1]] + 1;
                        queue.add(new int[]{n, m});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Programmers_게임맵최단거리 solution = new Programmers_게임맵최단거리();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int result = solution.solution(maps);
        System.out.println("최단 경로의 길이: " + result);
    }

}
