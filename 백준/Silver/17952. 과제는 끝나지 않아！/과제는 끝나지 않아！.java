import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Task {
        private int time;
        private int score;

        public Task(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Task> assignment = new ArrayDeque<>();
        int totalScore = 0;
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
            int hasTask = Integer.parseInt(tk.nextToken());
            if (hasTask == 0) {
                if (!assignment.isEmpty()) {
                    Task task = assignment.pop();
                    int time = task.time - 1;
                    if (time == 0) {
                        totalScore += task.score;
                    } else {
                        assignment.push(new Task(task.score, time));
                    }
                }
                continue;
            }

            int score = Integer.parseInt(tk.nextToken());
            int time = Integer.parseInt(tk.nextToken()) - 1;
            if (time == 0) {
                totalScore += score;
            } else {
                assignment.push(new Task(score, time));
            }
        }

        System.out.println(totalScore);
    }
}
