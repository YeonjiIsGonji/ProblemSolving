package BAEKJOON;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nList = new int[500000];
        int[] mList = new int[500000];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nList[i] = Integer.parseInt(tk.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer tk2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            mList[i] = Integer.parseInt(tk2.nextToken());
        }

        Arrays.sort(nList, 0, N); //정렬
        for (int i = 0; i < M; i++) {
            int findNumber = mList[i];
            int left = 0;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nList[mid] == findNumber) {
                    bw.write("1 ");
                    break;
                } else if (nList[mid] > findNumber) {
                    right = mid - 1;
                } else if (nList[mid] < findNumber) {
                    left = mid + 1;
                }
            }
            if (left > right) {
                 bw.write("0 ");
            }
        }
        bw.flush();
        br.close();
    }
}

