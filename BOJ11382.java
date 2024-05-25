package BAEKJOON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        List<String> numList = new ArrayList<>();

        while (tk.hasMoreTokens()) {
           numList.add(tk.nextToken());
        }
        BigInteger num1 = new BigInteger(numList.get(0));
        BigInteger num2 = new BigInteger(numList.get(1));
        BigInteger num3 = new BigInteger(numList.get(2));

        System.out.println(num1.add(num2).add(num3));
    }
}
