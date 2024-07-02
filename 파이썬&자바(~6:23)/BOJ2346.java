package BAEKJOON;

import java.io.*;
import java.util.*;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
//        int N = 5;

        // 풍선 리스트 생성
        List<Integer> balloon = new ArrayList<>();
        boolean[] isRemoved = new boolean[N];

        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
        while (tk.hasMoreTokens()) {
            balloon.add(Integer.parseInt(tk.nextToken()));
        }

//        List<Integer> balloon = Arrays.asList(3, 2, 1, -3, -1);

        int removedBallonCnt = 0;
        int point = 0;
        while (removedBallonCnt < N) {
            isRemoved[point] = true;
            removedBallonCnt++;
            bw.write((point + 1) + " ");

            if (removedBallonCnt == N) {
                break;
            }

            Integer balloonValue = balloon.get(point);

            // 그냥 더한 값
            point += balloonValue;

            // 우리 boundary 안으로 값을 가지고 와야된다.
//            point += N;
//            point %= N;

            if (point < 0) {
                point += N;
            } else if (point >= N) {
                point -= N;
            }

            // 추가 탐색
            while (isRemoved[point]) { // isRemoved[point] = true;
                if (balloonValue > 0) {
                    point++;
                } else if (balloonValue < 0) {
                    point--;
                }

                if (point < 0) {
                    point += N;
                } else if (point >= N) {
                    point -= N;
                }
            }

            // 탐색 끝, 결과 저장
        }

        bw.flush();
        bw.close();
    }
}
