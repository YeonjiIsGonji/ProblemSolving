import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 1. 이중배열 graph 를 이용해 체스판 구현 - 킹 위치(curX, curY) = 1, 돌 위치(sX, sY) = 2, 그 외 0
     * 2. for 문
     *  2-1. 주어진 이동방향에 따라 nextX, nextY 구하기
     *  2-2. 0 <= nextX, nextY <= 7 범위의 유효성 검사
     *  2-3. (nextX, nextY)  = 0 이면 킹 이동, 2 이면 킹 이동 후 돌도 이동
     * 3. Y =[A, B, C, .. H] X = [8, 7, 6, .. 1]
     *  킹 위치 : Y[curY] + X[curX], 돌 위치 : Y[sY] + X[sX]
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        String king = tk.nextToken();
        String stone = tk.nextToken();
        int N = Integer.parseInt(tk.nextToken());

        int curX = 0;
        int curY = 0;
        int sX = 0;
        int sY = 0;
        int nextX, nextY;

        char[] Y = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int[] X = new int[]{8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < 8; i++) {
            if (king.charAt(0) == Y[i]) {
                curY = i;
            }
            if (Integer.parseInt(String.valueOf(king.charAt(1))) == X[i]) {
                curX = i;
            }
            if (stone.charAt(0) == Y[i]) {
                sY = i;
            }
            if (Integer.parseInt(String.valueOf(stone.charAt(1))) == X[i]) {
                sX = i;
            }
        }

        int[][] graph = new int[8][8];
        graph[curX][curY] = 1;
        graph[sX][sY] = 2;

        for (int i = 0; i < N; i++) {
            String dir = br.readLine();
            if (dir.equals("R")) {
                nextX = curX;
                nextY = curY + 1;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sY = sY + 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sY = sY - 1;
                        }
                    }
                }
            } else if (dir.equals("L")) {
                nextX = curX;
                nextY = curY - 1;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sY = sY - 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sY = sY + 1;
                        }
                    }
                }
            } else if (dir.equals("T")) {
                nextX = curX - 1;
                nextY = curY;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sX = sX - 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sX = sX + 1;
                        }
                    }
                }
            } else if (dir.equals("B")) {
                nextX = curX + 1;
                nextY = curY;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sX = sX + 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;

                        } else {
                            sX = sX - 1;
                        }
                    }
                }
            } else if (dir.equals("LT")) {
                nextX = curX - 1;
                nextY = curY - 1;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sX = sX - 1;
                        sY = sY - 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sX = sX + 1;
                            sY = sY + 1;
                        }
                    }
                }
            } else if (dir.equals("LB")) {
                nextX = curX + 1;
                nextY = curY - 1;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sX = sX + 1;
                        sY = sY - 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sX = sX - 1;
                            sY = sY + 1;
                        }
                    }
                }
            } else if (dir.equals("RT")) {
                nextX = curX - 1;
                nextY = curY + 1;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sX = sX - 1;
                        sY = sY + 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sX = sX + 1;
                            sY = sY - 1;
                        }
                    }
                }
            } else if (dir.equals("RB")) {
                nextX = curX + 1;
                nextY = curY + 1;
                if (0 <= nextX && nextX < 8 && 0 <= nextY && nextY < 8) {
                    if (graph[nextX][nextY] == 0) {
                        moveK(nextX, nextY, graph, curX, curY);
                        curX = nextX;
                        curY = nextY;
                    } else if (graph[nextX][nextY] == 2) {
                        sX = sX + 1;
                        sY = sY + 1;
                        if (0 <= sX && sX < 8 && 0 <= sY && sY < 8) {
                            moveS(nextX, nextY, graph, curX, curY, sX, sY);
                            curX = nextX;
                            curY = nextY;
                        } else {
                            sX = sX - 1;
                            sY = sY - 1;
                        }
                    }
                }
            }
        }

        System.out.println(String.valueOf(Y[curY]) + String.valueOf(X[curX]));
        System.out.println(String.valueOf(Y[sY]) + String.valueOf(X[sX]));
    }

    public static void moveK(int nextX, int nextY, int[][] graph, int curX, int curY) {
        graph[nextX][nextY] = 1;
        graph[curX][curY] = 0;
    }

    public static void moveS(int nextX, int nextY, int[][] graph, int curX, int curY, int sX, int sY) {
        graph[sX][sY] = 2;
        graph[nextX][nextY] = 1;
        graph[curX][curY] = 0;
    }
}
