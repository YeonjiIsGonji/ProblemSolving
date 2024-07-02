package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        String[] arrayN = new String[N];
        LinkedList<String> arrayM = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            arrayN[i] = br.readLine();
        }
        for (int j = 0; j < M; j++) {
            arrayM.add(br.readLine());
        }

        int count = 0;
        while (!arrayM.isEmpty()) {
            String checkM = arrayM.pop();
            for (int i = 0; i < N; i++) {
                String checkN = arrayN[i];
                if (checkM.equals(checkN)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
