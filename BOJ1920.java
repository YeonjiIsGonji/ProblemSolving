package BAEKJOON;

import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nList = new int[100000];
        int[] mList = new int[100000];

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            nList[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        i = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        while (stringTokenizer.hasMoreTokens()) {
            mList[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }

        // 정렬 => 오름차순
        Arrays.sort(nList, 0, N);

        for (i = 0; i < M; i++) {
            int findNumber = mList[i];

            // 이분탐색 -> nList
            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nList[mid] == findNumber) {
                    bufferedWriter.write("1\n");
                    break;
                } else if (nList[mid] < findNumber) {
                    left = mid + 1;
                } else if (nList[mid] > findNumber) {
                    right = mid - 1;
                }
            }

            if (left > right) {
                bufferedWriter.write("0\n");
            }
        }

        bufferedWriter.flush();
        bufferedReader.close();
    }
}
