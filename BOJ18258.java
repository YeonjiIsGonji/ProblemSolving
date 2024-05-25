package BAEKJOON;

import java.io.*;
import java.util.*;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            List<String> inputList = new ArrayList<>();

            while (tk.hasMoreTokens()) {
                inputList.add(tk.nextToken());
            }

            if (inputList.get(0).equals("push")) {
                deque.add(Integer.parseInt(inputList.get(1)));
            } else if (inputList.get(0).equals("pop")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.remove() + "\n");
                }
            } else if (inputList.get(0).equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (inputList.get(0).equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (inputList.get(0).equals("front")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.peek() + "\n");
                }
            } else if (inputList.get(0).equals("back")) {
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
