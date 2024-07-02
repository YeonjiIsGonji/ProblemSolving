package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            while (tk.hasMoreTokens()) {
                numList.add(Integer.parseInt(tk.nextToken()));
            }
        }
        int X = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (numList.get(i) == X) {
                count++;
            }
        }
        System.out.println(count);
    }
}
