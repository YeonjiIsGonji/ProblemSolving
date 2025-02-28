import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int sizeA = Integer.parseInt(input[0]);
            int sizeB = Integer.parseInt(input[1]);

            int[] A = new int[sizeA];
            int[] B = new int[sizeB];

            input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                A[j] = Integer.parseInt(input[j]);
            }

            input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                B[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int pointA = sizeA - 1;
            int pointB = sizeB - 1;
            int count = 0;

            //제일 큰 값에서 아래로 내려가기
            while (pointA >= 0) {
                if (A[pointA] > B[pointB]) {
                    count += pointB + 1;
                    pointA--;
                } else if (A[pointA] <= B[pointB]) {
                    if (pointB > 0) {
                        pointB--;
                    } else {
                        break;
                    }
                }
            }

            bw.write(String.valueOf(count));
            if (i < T - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
