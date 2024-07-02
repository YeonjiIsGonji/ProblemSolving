package BAEKJOON;

import java.io.*;

public class BOJ2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int Q;
        int D;
        int N;
        int P;

        for (int i = 0; i < T; i++) {
            int money = Integer.parseInt(br.readLine());
            Q = money / 25;
            D = (money % 25) / 10;
            N = ((money % 25) % 10) / 5;
            P = (((money % 25) % 10) % 5) ;
            bw.write(Q + " " + D + " " + N + " " + P);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
