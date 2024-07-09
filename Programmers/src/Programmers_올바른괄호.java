import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Deque<String> stack = new ArrayDeque<>();
        //char[] arr = s.toCharArray(); String을 배열로 만들어서 푸는 방법
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i)); // string으로 변환하지 않고 char로 풀어도 된다!
            if (s1.equals("(")) { // char 일 땐, .equals 대신 = 로 쓰기
                stack.push("(");
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_올바른괄호 s = new Programmers_올바른괄호();
        String s1 = ")()(";
        boolean result = s.solution(s1);
        System.out.println(result);
    }
}
