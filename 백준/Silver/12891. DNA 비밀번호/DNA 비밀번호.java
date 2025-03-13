import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        String[] DNA = br.readLine().split("");

        checkArr = new int[4];
        myArr = new int[4];
        int result = 0;
        checkSecret = 0;

        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(input[i]);
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            Add(DNA[i]);
        }

        if (checkSecret == 4) {
            result++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(DNA[i]);
            Remove(DNA[j]);
            if (checkSecret == 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void Add(String s) {
        switch (s) {
            case "A":
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case "C":
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case "G":
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case "T":
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(String s) {
        switch (s) {
            case "A":
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case "C":
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case "G":
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case "T":
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
