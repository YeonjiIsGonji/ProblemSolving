package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(array,0, N);

        int count = 0;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (array[left] + array[right] == X) {
                count++;
                left++;
                right--;
            } else if (array[left] + array[right] > X) {
                right--;
            } else if (array[left] + array[right] < X) {
                left++;
            }
        }
        System.out.println(count);
    }
}
