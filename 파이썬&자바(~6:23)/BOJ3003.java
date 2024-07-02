package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        int King = 1 - Integer.parseInt(tk.nextToken());
        int Queen = 1 - Integer.parseInt(tk.nextToken());
        int Rook = 2 - Integer.parseInt(tk.nextToken());
        int Bishop = 2 - Integer.parseInt(tk.nextToken());
        int Knight = 2 - Integer.parseInt(tk.nextToken());
        int pawn = 8 - Integer.parseInt(tk.nextToken());

        bw.write(King + " " + Queen + " " + Rook + " " + Bishop + " " + Knight + " " + pawn);
        bw.flush();
        bw.close();
    }
}
