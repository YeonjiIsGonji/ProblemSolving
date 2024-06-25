import java.io.*;
import java.util.ArrayList;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        ArrayList<Character> S = new ArrayList<>();
        char[] alphabet = new char[26];

        for (int i = 0; i < input.length(); i++) {
            S.add(input.charAt(i));
        }

        //알파벳 리스트 생성, 알파벳 위치 출력
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
            bw.write(S.indexOf(alphabet[i]) + " ");
        }
        bw.flush();
        bw.close();

    }
}
