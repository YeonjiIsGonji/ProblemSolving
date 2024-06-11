package BAEKJOON;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] X = new String[3];
        String[] Y = new String[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            X[i] = tk.nextToken();
            Y[i] = tk.nextToken();
        }

        Arrays.sort(X);
        Arrays.sort(Y);
        if (X[0].equals(X[1])) {
            bw.write(String.valueOf(X[2]));
        } else if (X[1].equals(X[2])) {
            bw.write(X[0]);
        }
        bw.write(" ");
        if (Y[0].equals(Y[1])) {
            bw.write(String.valueOf(Y[2]));
        } else if (Y[1].equals(Y[2])) {
            bw.write(Y[0]);
        }
        bw.flush();
        bw.close();
    }
}
