package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //사용자가 입력한 값(모두)을 br에 저장
        StringBuilder sb = new StringBuilder(); //println으로 하면 처리속도가 너무 느려서 stringBuilder에 넣고 나중에 출력!
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine()); // N = 9 br에 있는 값을 한 줄만 읽고(readLine) 그것을 숫자로 변환하여 N에 저장
        for (int i = 0; i < N; i++) { // "4"
            List<Integer> list = new ArrayList<>(); // list = []
            StringTokenizer tk = new StringTokenizer(br.readLine(), " "); // readLine이 다음 한 줄 읽고 그걸 공백으로 구분해서 토큰으로 저장. ["1", "3"] 토근이 2개! 1 / 3
            while (tk.hasMoreTokens()) { //너 토근 있어?
                String input = tk.nextToken(); // input = "3" 응 나 토큰 있어. 그거 input에 넣고 token에서는 뺄게.(pop과 같음)
                list.add(Integer.parseInt(input)); // list = [1, 3]
            }

            if (list.get(0) == 1) {
                int X = list.get(1);
                stack.push(X);
            } else if (list.get(0) == 2) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop());
                    sb.append("\n");
//                    System.out.println(stack.pop());
                } else {
                    sb.append("-1\n");
//                    System.out.println("-1");
                }
            } else if (list.get(0) == 3) {
                sb.append(stack.size());
                sb.append("\n");
//                System.out.println(stack.size());
            } else if (list.get(0) == 4) {
                if (stack.isEmpty()) {
                    sb.append("1\n");
//                    System.out.println("1");
                } else {
                    sb.append("0\n");
//                    System.out.println("0");
                }
            } else if (list.get(0) == 5) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek());
                    sb.append("\n");
//                    System.out.println(stack.peek());
                } else {
                    sb.append("-1\n");
//                    System.out.println("-1");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
