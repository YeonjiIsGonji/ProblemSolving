import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1920_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //배열이 array 보다 더 빠르다.
        int N = Integer.parseInt(br.readLine());
//        int[] arrN = new int[100000];
        ArrayList<Integer> arrN = new ArrayList<>();

        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
//            arrN[i] = Integer.parseInt(tk.nextToken());
            arrN.add(Integer.parseInt(tk.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[100000];

        tk = new StringTokenizer(br.readLine(), " ");

//        Arrays.sort(arrN); //오름차순 정렬
        arrN.sort(Comparator.naturalOrder());
        //이분탐색
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = arrN.size() - 1;
            int X = Integer.parseInt(tk.nextToken());
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arrN.get(mid) == X) {
                    bw.write("1\n");
                    break;
                } else if (arrN.get(mid) > X) {
                    right = mid - 1;
                } else if (arrN.get(mid) < X) {
                    left = mid + 1;
                }
            }
            if (left > right) {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();

    }
}
