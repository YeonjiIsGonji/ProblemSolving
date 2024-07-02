package BAEKJOON;

import java.io.*;
import java.util.*;

public class BOJ28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            List<Integer> inputList = new ArrayList<>();

            while (tk.hasMoreTokens()) {
                inputList.add(Integer.parseInt(tk.nextToken()));
            }
            if (inputList.get(0) == 1 ) {
                deque.addFirst(inputList.get(1));
            } else if (inputList.get(0) == 2) {
                deque.addLast(inputList.get(1));
            } else if (inputList.get(0) == 3) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.removeFirst() + "\n");
                }
            } else if (inputList.get(0) == 4) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.removeLast() + "\n");
                }
            } else if (inputList.get(0) == 5) {
                bw.write(deque.size() + "\n");
            } else if (inputList.get(0) == 6) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (inputList.get(0) == 7) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.getFirst() + "\n");
                }
            } else if (inputList.get(0) == 8) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.getLast() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();

    }
}
