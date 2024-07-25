package week5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] visited = new int[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();


        //1. grid 순회
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                // grid 모두 순회
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    while (!queue.isEmpty()) {
                        int[] curNode = queue.poll();
                        // nextNode 확인
                        for (int k = 0; k < x.length; k++) {
                            int m = curNode[1] + x[k]; // 좌우이동
                            int n = curNode[0] + y[k]; // 상하이동
                            // n, m 범위가 grid 내에 존재하는지 확인
                            if (0 <= m && m < colLength && 0 <= n && n < rowLength) {
                                if (visited[n][m] == 0 && grid[n][m] == '1') {
                                    visited[n][m] = 1;
                                    queue.add(new int[]{n, m}); // nextNode 큐에 추가
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    // 굳이?
    public boolean isValid(int n, int m, int rowLength, int colLength) {
        return 0 <= m && m < colLength && 0 <= n && n < rowLength;
    }

    public static void main(String[] args) {
        LC200 lc200 = new LC200();

        // 테스트 케이스 설정
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        // numIslands 메서드 호출
        int numberOfIslands = lc200.numIslands(grid);

        // 결과 출력
        System.out.println("Number of islands: " + numberOfIslands);
    }
}
