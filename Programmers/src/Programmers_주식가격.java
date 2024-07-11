import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayDeque;
import java.util.Deque;

public class Programmers_주식가격 {
    public int[] solution1(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];

        Deque<Integer> dayStack = new ArrayDeque<>();
        Deque<Integer> priceStack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            // prices[i]
            int curPrice = prices[i];
            int curDay = i;

            while (!dayStack.isEmpty() && !priceStack.isEmpty()) {
                if (priceStack.peekLast() > curPrice) {
                    Integer oldPrice = priceStack.removeLast();
                    Integer oldDay = dayStack.removeLast();

                    answer[oldDay] = (curDay - oldDay);
                } else {
                    break;
                }
            }

            dayStack.addLast(curDay);
            priceStack.addLast(curPrice);
        }

        while (!dayStack.isEmpty() && !priceStack.isEmpty()) {
            Integer oldPrice = priceStack.removeLast();
            Integer oldDay = dayStack.removeLast();

            answer[oldDay] = ((N - 1) - oldDay);
        }
        return answer;
    }

    public int[] solution2(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = (N - 1) - i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] testCase = new int[100000];
        for (int i = 0; i < 100000; i++) {
            testCase[i] = i;
        }

        Programmers_주식가격 ex = new Programmers_주식가격();

        Long startTime = System.currentTimeMillis();
        ex.solution1(testCase);
        Long endTime = System.currentTimeMillis();
        System.out.println("1번실험결과 : " + (endTime - startTime));


        Long startTime2 = System.currentTimeMillis();
        ex.solution2(testCase);
        Long endTime2 = System.currentTimeMillis();
        System.out.println("2번실험결과 : " + (endTime2 - startTime2));

    }
}
