package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(list, 0, N);

        int left = 0;
        int right = N - 1;

        int answerInd1 = 0;
        int answerInd2 = N - 1;

        while (left < right) {
            int sum = list[left] + list[right];
            int answer = list[answerInd1] + list[answerInd2];

            if (sum == 0) {
                answerInd1 = left;
                answerInd2 = right;
                break;
            } else if (sum > 0) {
                if (Math.abs(sum) < Math.abs(answer)) {
                    answerInd1 = left;
                    answerInd2 = right;
                }
                right--;
            } else if (sum < 0) {
                if (Math.abs(sum) < Math.abs(answer)) {
                    answerInd1 = left;
                    answerInd2 = right;
                }
                left++;
            }
        }

        System.out.println(list[answerInd1] + " " + list[answerInd2]);
    }
}
