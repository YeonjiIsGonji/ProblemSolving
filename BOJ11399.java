package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        List<Integer> timeList = new ArrayList<>();
        int sum = 0;

        while (tk.hasMoreTokens()) {
            timeList.add(Integer.parseInt(tk.nextToken()));
        }

        // 정렬


        // 답 계산
        for (int i = 0; i < N; i++) {
            sum += (N - i) * timeList.get(i);
        }

        System.out.println(sum);
    }
}
