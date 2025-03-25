import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 1;
        while (queue.size() > 1) {
            if (count % 2 != 0) {
                result.add(queue.poll());
                count++;
            } else {
                queue.offer(queue.poll());
                count++;
            }
        }

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + " ");
        }
        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        bw.close();
    }
}
