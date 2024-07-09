import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_괄호회전하기 {
        public int solution(String s) {
            Deque<Character> q = new ArrayDeque<>();

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                q.add(s.charAt(i));
            }

            // 2. 문자열 돌리기
            for (int i = 0; i < s.length(); i++) {
                q.add(q.remove());
                Deque<Character> stack = new ArrayDeque<>();
                //유효성 검사
                for (Character c : q) {
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else if (c == ')') {
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                            break;
                        }
                    } else if (c == '}') {
                        if (!stack.isEmpty() && stack.peek() == '{') {
                            stack.pop();
                        } else {
                            stack.push(c);
                            break;
                        }
                    } else if (c == ']') {
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(c);
                            break;
                        }
                    }
                }
                if (stack.isEmpty()) {
                    count++;
                }
            }
            return count;
        }


    public static void main(String[] args) {
        Programmers_괄호회전하기 ex = new Programmers_괄호회전하기();
        ;
        System.out.println(ex.solution("[)(]"));

    }
}
