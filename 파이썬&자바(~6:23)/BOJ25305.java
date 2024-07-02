package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk1 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk1.nextToken());
        int K = Integer.parseInt(tk1.nextToken());
        List<Integer> array = new ArrayList<>();

        StringTokenizer tk2 = new StringTokenizer(br.readLine()," ");
        while (tk2.hasMoreTokens()) {
            array.add(Integer.parseInt(tk2.nextToken()));
        }

        array.sort(Comparator.reverseOrder());
        System.out.println(array.get(K-1));


    }
}
