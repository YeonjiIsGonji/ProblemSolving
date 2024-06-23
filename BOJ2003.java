package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int[] array = new int[N];
        int count = 0;

        StringTokenizer tk2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tk2.nextToken());
        }

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            int j = i;
            while (j < array.length) {
                sum += array[j];
                j++;
                if (sum == M) {
                    count++;
                    break;
                } else if (sum > M) {
                    break;
                }
            }

        }

        System.out.println(count);
    }
}
