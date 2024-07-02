package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        List<Integer> timeList = new ArrayList<>();

        while (tk.hasMoreTokens()) {
            timeList.add(Integer.parseInt(tk.nextToken()));
        }

        timeList.sort(Comparator.reverseOrder()); //내림차순 정렬(가장 큰 수부터 작은 수를 곱해야 한다)
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += timeList.get(i) * (i + 1);
        }

        System.out.println(sum);
    }
}
