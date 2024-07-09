import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {

        int N = queue1.length;
        int answer = Integer.MAX_VALUE;

        Long totalSum = 0L;
        for (int i = 0; i < N; i++) {
            totalSum += queue1[i];
            totalSum += queue2[i];
        }
        Long goal = totalSum / 2;

        if (totalSum % 2 != 0) {
            return -1;
        }

        Long[] list = new Long[2 * N];
        for (int i = 0; i < N; i++) {
            list[i] = 1L * queue1[i];
        }
        for (int i = 0; i < N; i++) {
            list[N + i] = 1L * queue2[i];
        }

        for (int left = 0; left < 2 * N; left++) {
            int right = left;
            Long sum = 1L * list[right];

            while (sum < goal && right + 1 < 2 * N) {
                sum += list[++right];
            }

            // left ~ right 범위까지의 합이 Goal 이 된 경우.
            if (sum == goal) {
                int newAnswer;
                if (right < N) {
                    newAnswer = 3 * N + 1 + left + right;
                } else {
                    newAnswer = left + (right - N + 1);
                }

                answer = Math.min(answer, newAnswer);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

//    public int solution(int[] queue1, int[] queue2) {
//        Queue<Integer> q1 = new ArrayDeque<>();
//        Queue<Integer> q2 = new ArrayDeque<>();
//
//        int answer = 0;
//        long sum = 0;
//        long sumQ1 = 0;
//        long sumQ2 = 0;
//        int count = 0;
//
//        //1. 목표 구하기
//        for (int i = 0; i < queue1.length; i++) {
//            sum += queue1[i] + queue2[i];
//            sumQ1 += queue1[i];
//            sumQ2 += queue2[i];
//            q1.add(queue1[i]);
//            q2.add(queue2[i]);
//        }
//        long target = sum / 2;
//
//        // 2. 옮기기
//        if (sumQ1 == sumQ2) {
//            return 0;
//        }
//        for (int i = 0; i < 4 * queue1.length; i++) {
//        //while (count < 4 * queue1.length) { //원래 모양으로 돌아올때까지 걸리는 횟수 대략 4n
//            if (sumQ1 < sumQ2) {
//                int temp = q2.peek();
//                if (temp > target) {
//                    return -1;
//                }
//                sumQ1 += temp;
//                sumQ2 -= temp;
//                q1.add(q2.remove());
//                answer++;
//                count++;
//            } else if (sumQ2 < sumQ1) {
//                int temp = q1.peek();
//                if (temp > target) {
//                    return -1;
//                }
//                sumQ1 -= temp;
//                sumQ2 += temp;
//                q2.add(q1.remove());
//                answer++;
//                count++;
//            }
//            if (sumQ1 == sumQ2) {
//                return answer;
//            }
//        }
//        if (sumQ1 != sumQ2) {
//            return -1;
//        }
//        return answer;
//    }


    public static void main(String[] args) {
        Programmers_두큐합같게만들기 ex = new Programmers_두큐합같게만들기();
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        System.out.println("Test 1 : " + ex.solution(queue1, queue2));

        int[] queue3 = {1};
        int[] queue4 = {1};
        System.out.println("Test 2 : " + ex.solution(queue3, queue4));

        int[] queue5 = {1, 2, 1, 2};
        int[] queue6 = {1, 2, 1, 10};
        System.out.println("Test 3 : " + ex.solution(queue5, queue6));

        int[] queue7 = {1};
        int[] queue8 = {3};
        System.out.println("Test 4 : " + ex.solution(queue7, queue8));
    }
}
