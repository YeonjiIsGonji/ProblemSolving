package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i = 1; i <= N; i++) {
            List<Integer> numList = new ArrayList<>();
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int sum = 0;

            while(tk.hasMoreTokens()) {
                int num = Integer.parseInt(tk.nextToken());
                numList.add(num);
                sum += num;
            }
            System.out.println("Case #" + i + ": " + numList.get(0) + " + " + numList.get(1) + " = " + sum);
        }
    }
}
