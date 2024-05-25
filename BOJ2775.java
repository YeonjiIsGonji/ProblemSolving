package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] floor = new int[15][14];
        for (int i = 0; i < 14; i++) {
            floor[0][i] = i + 1;
        } //0층 입주!
        for (int i = 0; i < 15; i++) {
            floor[i][0] = 1;
        } //각층 1호실 입주!
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 14; j++) {
                floor[i][j] = floor[i][j-1] + floor[i-1][j];
            }
        }//모든 호실 입주 완료!
//
        for (int i= 0; i < N; i++) {
            int f = Integer.parseInt(br.readLine());
            int r = Integer.parseInt(br.readLine());
            System.out.println(floor[f][r-1]);
        }
    }
    }
