package BAEKJOON;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ10816_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] cardList = new int[N];
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        while (tk.hasMoreTokens()) {

            for (int i = 0; i < cardList.length; i++) {
                cardList[i] = Integer.parseInt(tk.nextToken());
            }
        }

        Arrays.sort(cardList, 0, N); //오름차순 정렬

        int M = Integer.parseInt(br.readLine());
        StringTokenizer tk2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(tk2.nextToken()); // card = 10;
            int count = rightBound(card, cardList) - leftBound(card, cardList);
            bw.write(count +  " ");
        }
        bw.flush();
        bw.close();
    }

    private static int leftBound (int card, int[] cardList) {
        int left = 0;
        int right = cardList.length;

        while (left < right) {
            
            int mid = (left + right) / 2;
            if ( card <= cardList[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int rightBound (int card, int[] cardList) {
        int left = 0;
        int right = cardList.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (card < cardList[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
