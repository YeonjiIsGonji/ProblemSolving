package week5;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_미로찾기 {
    int[] dc = {-1, 1, 0, 0};
    int[] dr = {0, 0, -1, 1};
    String[][] graph;
    int[][] visited;
    int rowLength, colLength;
    int count, totalCount, startRow, startCol, levRow, levCol, exitRow, exitCol;

    public int solution(String[] maps) {
        rowLength = maps.length;
        colLength = maps[0].length();
        visited = new int[rowLength][colLength];
        graph = new String[rowLength][colLength];

        // graph 생성
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                graph[i][j] = String.valueOf(maps[i].charAt(j));
                // start, 레버, 출구 위치 구하기
                if (graph[i][j].equals("S")) {
                    startRow = i;
                    startCol = j;
                } else if (graph[i][j].equals("L")) {
                    levRow = i;
                    levCol = j;
                } else if (graph[i][j].equals("E")) {
                    exitRow = i;
                    exitCol = j;
                }
            }
        }

        // 1. start -> 레버까지 이동
        count = bfs(startRow, startCol, levRow, levCol);
        if (count == -1) return -1; // 레버까지 갈 수 없으니 -1
        totalCount += count;
        visited =  new int[rowLength][colLength]; // 들렸던 곳 다시 지나갈 수 있으니 리셋

        // 2. 레버 -> 출구까지 이동
        count = bfs(levRow, levCol, exitRow, exitCol);
        if (count == -1) return -1; // 출구까지 갈 수 없으니 -1
        totalCount += count;

        return totalCount;
    }

    public int bfs(int i, int j, int targetRow, int targetCol) {
        Queue<int[]> queue = new LinkedList<>();
        if (visited[i][j] == 0 && (graph[i][j].equals("O") || graph[i][j].equals("S") || graph[i][j].equals("L"))) {
            queue.add(new int[]{i, j});
            while (!queue.isEmpty()) {
                int[] curNode = queue.poll();
                int curRow = curNode[0];
                int curCol = curNode[1];

                // 목표 지점(레버 or 출구)에 도달
                if (curRow == targetRow && curCol == targetCol) {
                    return visited[curRow][curCol];
                }

                for (int k = 0; k < 4; k++) {
                    int nextRow = curRow + dr[k];
                    int nextCol = curCol + dc[k];
                    if (0 <= nextRow && nextRow < rowLength && 0 <= nextCol && nextCol < colLength) {
                        if (isValid(nextRow, nextCol)) {
                            visited[nextRow][nextCol] = visited[curRow][curCol] + 1;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public boolean isValid(int nextRow, int nextCol) {
        return (graph[nextRow][nextCol].equals("O") || graph[nextRow][nextCol].equals("S") || graph[nextRow][nextCol].equals("L") || graph[nextRow][nextCol].equals("E")) && visited[nextRow][nextCol] == 0;
    }

    public static void main(String[] args) {
        Programmers_미로찾기 solution = new Programmers_미로찾기();
        // 테스트 케이스 1
        String[] maps = {
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        };

        System.out.println("Test Case 1: " + solution.solution(maps)); // 예상 결과: 16

        // 테스트 케이스 2
        String[] maps4 = {
                "LOOXS",
                "OOOOX",
                "OOOOO",
                "OOOOO",
                "EOOOO"
        };
        System.out.println("Test Case 2: " + solution.solution(maps4)); // 예상 결과: -1

    }
}
