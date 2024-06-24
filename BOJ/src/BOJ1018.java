import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());

        // 첫 번째 칸이 검정색 (8x8)
        String[][] blackChess = {
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"}
        };

        // 첫 번째 칸이 흰색 (8x8)
        String[][] whiteChess = {
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"}
        };

        //보드판 입력
        String[][] board = new String[M][N];

        for (int row = 0; row < M; row++) {
            String input = br.readLine();
            for (int column = 0; column < N; column++) {
                board[row][column] = String.valueOf(input.charAt(column));
            }
        }

        ArrayList<Integer> blackCount = new ArrayList<>();
        ArrayList<Integer> whiteCount = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // startPoint = board[i][j]
                if (i + 7 < M && j + 7 < N) { //주어진 보드 크기를 넘기지 않아야 함
                    int black = 0;
                    int white = 0;
                    String[][] newChess = new String[8][8];
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            newChess[k][l] = board[i + k][j + l];
                            //검정색 체스판을 만들 때 색칠해야 하는 수 구하기
                            if (!newChess[k][l].equals(blackChess[k][l])) {
                                black++;
                            }
                            //흰색 체스판을 만들 때 색칠해야 하는 수 구하기
                            if (!newChess[k][l].equals(whiteChess[k][l])) {
                                white++;
                            }
                        }
                    }
                    blackCount.add(black);
                    whiteCount.add(white);

                } else {
                    continue;
                }

            }
        }
        blackCount.sort(Comparator.naturalOrder());
        whiteCount.sort(Comparator.naturalOrder());
        int blackMin = blackCount.get(0);
        int whiteMin = whiteCount.get(0);
        if (blackMin <= whiteMin) {
            System.out.println(blackMin);
        } else if (whiteMin <= blackMin) {
            System.out.println(whiteMin);
        }
    }
}
