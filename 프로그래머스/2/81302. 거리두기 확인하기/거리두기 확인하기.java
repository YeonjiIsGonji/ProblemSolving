import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            int result = checkRoom(places[i]);
            answer[i] = result;
        }
        return answer;
    }
    
    private int checkRoom(String[] room) {
        char[][] map = new char[5][5];
        int[] distX = {-1, 1, 0, 0};
        int[] distY = {0, 0, -1, 1};
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = room[i].charAt(j);
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    Queue<Integer> xQ = new LinkedList<>();
                    Queue<Integer> yQ = new LinkedList<>();
                    int[][] visited = new int[5][5];
                    
                    for (int k = 0; k < 5; k++) {
                        for (int l = 0; l < 5; l++) {
                            visited[k][l] = Integer.MAX_VALUE;
                        }
                    }
                    
                    xQ.add(i);
                    yQ.add(j);
                    visited[i][j] = 0;
                    
                    while(!xQ.isEmpty()) {
                        int curX = xQ.poll();
                        int curY = yQ.poll();
                        
                        for (int dr = 0; dr < 4; dr++) {
                            int nextX = curX + distX[dr];
                            int nextY = curY + distY[dr];
                            
                            if (visited[curX][curY] >= 2) {
                                continue;
                            }
                            
                            if (0 <= nextX && nextX < 5 && 0 <= nextY && nextY < 5) {
                                if (visited[nextX][nextY] != Integer.MAX_VALUE) {
                                    continue;
                                }
                                
                                if (map[nextX][nextY] == 'P') {
                                    return 0;
                                }
                                
                                if (map[nextX][nextY] != 'X') {
                                    xQ.add(nextX);
                                    yQ.add(nextY);
                                    visited[nextX][nextY] = visited[curX][curY] + 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}