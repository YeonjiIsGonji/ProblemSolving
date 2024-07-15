import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Programmers_기능개발 {
    public int[] solution1(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int[] rest = new int[N];
        int[] day = new int[N];
        Queue<Integer> progressQ = new ArrayDeque<>();
        Queue<Integer> answerQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            rest[i] = 100 - progresses[i];
            if (rest[i] % speeds[i] != 0) {
                day[i] = rest[i] / speeds[i] + 1;
            } else {
                day[i] = rest[i] / speeds[i];
            }
        }

        //1. 인덱스로 구하기
        for (int i = 0; i < N; i++) {
            if (!progressQ.isEmpty()) {
                int X = day[progressQ.peek()];
                if (X < day[i]) {
                    answerQueue.add(i - progressQ.remove());
                    progressQ.add(i);
                }
            } else {
                progressQ.add(i);
            }
        }
        answerQueue.add(N - progressQ.remove());

        int M = answerQueue.size();
        int[] answer = new int[M];
        for (int i = 0; i < M; i++) {
            answer[i] = answerQueue.remove();
        }

        return answer;
    }


    public int[] solution2(int[] progresses, int[] speeds){
        int N = progresses.length;
        int[] rest = new int[N];
        int[] day = new int[N];
        Queue<Integer> progressQ = new ArrayDeque<>();
        Queue<Integer> answerQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            rest[i] = 100 - progresses[i];
            if (rest[i] % speeds[i] != 0) {
                day[i] = rest[i] / speeds[i] + 1;
            } else {
                day[i] = rest[i] / speeds[i];
            }
        }
        //2. queue size로 구하기
        for (int i = 0; i < N; i++) {
            if (!progressQ.isEmpty()) {
                int X = day[progressQ.peek()]; // 첫번째 값
                if (X >= day[i]) {
                    progressQ.add(i);
                } else if (X < day[i]) {
                    answerQueue.add(progressQ.size());
                    progressQ.clear();
                    progressQ.add(i);
                }
            } else {
                progressQ.add(i);
            }
        }
        answerQueue.add(progressQ.size());
        progressQ.clear();

        int M = answerQueue.size();
        int[] answer = new int[M];
        for (int i = 0; i < M; i++) {
            answer[i] = answerQueue.remove();
        }

        return answer;
    }

    public int[] solution3(int[] progresses, int[] speeds) {
        int N = progresses.length;
        List<Integer> answer = new ArrayList<>();
        int ind = 0;

        while (ind < N) {
            // 하루를 시뮬레이션 진행
            for (int i = 0; i < N; i++) {
                progresses[i] += speeds[i];
            }

            // 배포 가능한지 확인.
            int releaseProject = 0;
            while (ind < N && progresses[ind] >= 100) {
                ind++;
                releaseProject++;
            }

            if (releaseProject != 0) {
                answer.add(releaseProject);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Programmers_기능개발 ex = new Programmers_기능개발();
        int[] result1 = ex.solution1(progresses, speeds);
        for (int i : result1) {
            System.out.print(i + ", ");
        }
        System.out.println();
        int[] result2 = ex.solution2(progresses, speeds);
        for (int i : result2) {
            System.out.print(i + ", ");
        }
    }
}
