package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk1 = new StringTokenizer(br.readLine(), " ");

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        while (tk1.hasMoreTokens()) {
            list1.add(Integer.parseInt(tk1.nextToken()));
        }

        int N = list1.get(0);
        int M = list1.get(1);
        //다른 사람풀이에서 토큰 간단하게 쓰는 법 참조
//        StringTokenizer st;
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            StringTokenizer tk2 = new StringTokenizer(br.readLine(), " ");
            while (tk2.hasMoreTokens()) {
                list2.add(Integer.parseInt(tk2.nextToken()));
            }
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer tk3 = new StringTokenizer(br.readLine(), " ");
            while (tk3.hasMoreTokens()) {
                list3.add(Integer.parseInt(tk3.nextToken()));
            }
        }
        //더 간단하게 쓰는 법
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                arrA[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];
        int[][] arr3 = new int[N][M];

        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr1[i][j] = list2.get(M * i + j);
                k++;
            }
        }

        k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr2[i][j] = list3.get(k);
                k++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
                bw.write(arr3[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
