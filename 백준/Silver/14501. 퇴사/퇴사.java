import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] time;
    static int[] cost;
    static int max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N];
        cost = new int[N];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            cost[i] = Integer.parseInt(input[1]);
        }

        dfs(0, 0);
        
        System.out.println(max);
    }

    public static void dfs(int day, int sum) {
        if (day >= N) {
            max = Math.max(max, sum);
            return;
        }

        if (time[day] + day <= N) {
            dfs(time[day] + day, sum + cost[day]);
        } 

        dfs(day + 1, sum);
    }
}
