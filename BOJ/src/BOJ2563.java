import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2563 {

    // 가로(100 이하) { 3, 15, 5 } -> 정사각형 가로변 { 3 ~ 13, 5 ~ 15 ,15 ~ 25 } - > {3, 5, 13, 15, 25} X 겹치는걸 알 수 없음
    // 가로변 시작점 기준으로 무조건 정렬하기X 세로랑 같이 봐야함.
    // { 3(s1) ~ 13(e1) & 5(s2) ~ 15(e2) } -> 1.start비교 : 3 vs 5 -> 5(maxS) / 2. end 비교 : 13 vs 15 -> 13 (minE) /
    // 3. 첫번째 정사각형 최대값 13 vs 두번째 정사각형 시작값 5  - > 5 < 13(ok) 즉, minE <= e1 && minE <= e2

    // { 5(s2) ~ 15 (e2) } vs { 15(s3) ~ 25 (e3) }
    // 1. if (s3 < e2) -> no.
    // 2. s3(newS) < ed

    // { 3(s1) ~ 13(e1) } vs { 5(s2) ~ 15(e2) }
    // 1. start 비교

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        int[][] squareArray = new int[N][4];
//        for (int i = 0; i < N; i++) {
//            StringTokenizer tk = new StringTokenizer(br.readLine()," ");
//            squareArray[i][0] = Integer.parseInt(tk.nextToken()); // Left
//            squareArray[i][1] = squareArray[i][0] + 10; // Right
//            squareArray[i][2] = Integer.parseInt(tk.nextToken()); // Bottom
//            squareArray[i][3] = squareArray[i][2] + 10; // Top
//            // [0]~[1] : x축 , [2]~[3] : y축
//        }
        int[][] squareArray = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine()," ");
            squareArray[i][0] = Integer.parseInt(tk.nextToken());
            squareArray[i][1] = Integer.parseInt(tk.nextToken());
        }

        //가로 기준 배열 정렬
        Arrays.sort(squareArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        // 두 색종이 비교
        int i = 0;
        int sum = 0;
        int x, y = 0;

        // 1. x축 : 두 색종이의 겹치는 시작점 < 첫번째 색종이 마지막 꼭지점
//        if (squareArray[i+1][0] < squareArray[i][1]) {
//            if (squareArray[i][1] < squareArray[i+1])
//                x =
//            // 2. y축 : 색종이의 위,아래 비교
//            // s1(Top) > s2(bottom) > s1(bottom)
//            if (squareArray[i][3] > squareArray[i+1][2] && squareArray[i+1][2] > squareArray[i][2]) {
//                sum +=
//            }
//
//        }

        while (true) {
            // x축
            int s1Bottom = squareArray[i][1];
            int s1Top = s1Bottom + 10;
            int s2Bottom = squareArray[i+1][1];
            int s2Top = s2Bottom + 10;
            // y축 비교
            if (squareArray[i+1][0] < squareArray[i][0] + 10 && s2Bottom < s1Top) {
                //x = 10 -
            }
            int diffX = Math.abs(squareArray[i+1][0] - squareArray[i][0]);
            //if (0 <diffX < 10)

        }




    }
}
