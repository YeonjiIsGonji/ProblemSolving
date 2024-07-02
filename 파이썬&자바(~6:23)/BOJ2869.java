package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(tk.nextToken());
        int down = Integer.parseInt(tk.nextToken());
        int height = Integer.parseInt(tk.nextToken());
        int day;

        if ((height - up) % (up - down) == 0) {
            day = (height - up) / (up - down) + 1;
        } else {
            day = (height - up) / (up - down) + 2;
        }
        System.out.println(day);
    }
}
