package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        List<String> numList = new ArrayList<>();

        while (tk.hasMoreTokens()) {
            numList.add(tk.nextToken());
        }

        StringBuilder strA = new StringBuilder(numList.get(0));
        StringBuilder strB = new StringBuilder(numList.get(1));

        int A = Integer.parseInt(strA.reverse().toString());
        int B = Integer.parseInt(strB.reverse().toString());

        if (A >= B) {
            System.out.println(A);
        } else {
            System.out.println(B);
        }
    }
}
