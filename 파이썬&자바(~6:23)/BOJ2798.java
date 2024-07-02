package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        StringTokenizer tk2 = new StringTokenizer(br.readLine()," ");
        List<Integer> card = new ArrayList<>();
        while (tk2.hasMoreTokens()) {
            card.add(Integer.parseInt(tk2.nextToken())); //카드 리스트 생성
        }

        List<Integer> combination = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = card.get(i) + card.get(j) + card.get(k);
                    combination.add(sum);
                }
            }
        }

        //오답
//        for (int i = 0; i < N - 2; i++) {
//            for (int j = 0; j < N - 2; j++) {
//                sum = card.get(i) + card.get(i+1) + card.get(j+2);
//                combination.add(sum);
//            }
//        }

        combination.sort(Comparator.reverseOrder());


        for (int i = 0; i < combination.size(); i++) {
            int num = combination.get(i);
            if (num <= M) {
                System.out.println(num);
                break;
            }
        }



    }
}
