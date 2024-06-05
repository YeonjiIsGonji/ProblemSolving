package BAEKJOON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int leftCount = 0;
            int rightCount = 0;
            int sum = 0;
            String[] VPS = br.readLine().split("");
            List<Integer> sumList = new ArrayList<>();
            for (String vps : VPS) {
                if (vps.equals("(")) {
                    sumList.add(1);
                    leftCount++;
                } else {
                    sumList.add(-1);
                    rightCount++;
                }
            }
            if (leftCount == rightCount) {
                for (int j = 0; j < VPS.length; j++) {
                    sum += sumList.get(j);
                    if (sum < 0) {
                        bw. write("NO\n");
                        break;
                    }
                }
                if(sum == 0) {
                    bw.write("YES\n");
                }
            }
            else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
//count == 0 이면 sum 구하는거로 바꾸기