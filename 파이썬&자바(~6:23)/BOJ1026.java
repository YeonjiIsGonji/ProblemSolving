package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tk1 = new StringTokenizer(br.readLine());
        StringTokenizer tk2 = new StringTokenizer(br.readLine());
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        while (tk1.hasMoreTokens()) {
            listA.add(Integer.parseInt(tk1.nextToken()));
        }
        while (tk2.hasMoreTokens()) {
            listB.add(Integer.parseInt(tk2.nextToken()));
        }

        listA.sort(Comparator.naturalOrder());
        listB.sort(Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += listA.get(i) * listB.get(i) ;
        }

        System.out.println(sum);
    }
}
