package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        int totalSec = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            for (int j = 0; j < dial.length; j++) {
                if (dial[j].indexOf(ch) != -1) {
                    int sec = j + 3;
                    totalSec += sec;
                }
            }
        }
        System.out.println(totalSec);
    }
}
