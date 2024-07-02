import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int n = 1;
        int location = 0;


        while (true) {
            // Y(인덱스) = 각 그룹의 첫번째 수 1, 2, 4, 7 ...
            int Y = (n * n - n + 2) / 2;
            // X가 몇 번째(n) 속한 그룹인지 확인
            if (X < Y) {
                n--;
                break;
            } else if (X == Y) {
                location = X - Y;
                break;
            }
            location = X - Y; // X > Y
            n++;
        }

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> reverseArray = new ArrayList<>();

        if (n == 0) {
            bw.write("1/1");
        } else {
            for (int i = 1; i <= n; i++) {
                array.add(i);
                reverseArray.add(i);
            }

            reverseArray.sort(Comparator.reverseOrder());

            if (n % 2 == 0) {
                bw.write(String.valueOf(array.get(location)));
                bw.write("/");
                bw.write(String.valueOf(reverseArray.get(location)));
            } else {
                bw.write(String.valueOf(reverseArray.get(location)));
                bw.write("/");
                bw.write(String.valueOf(array.get(location)));
            }
        }

        bw.flush();
        bw.close();
    }
}
