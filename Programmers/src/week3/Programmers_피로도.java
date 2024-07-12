package week3;

public class Programmers_피로도 {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        int cnt = 1;
        backtrack(k, visited, n, dungeons, cnt);
        return answer;
    }

    public void backtrack(int cur_k, boolean[] visited, int n, int[][] dungeons, int cnt) {
        // basecase
        if (cnt > answer) {

        }
        // recursive call
        for (int i = 0; i < n; i++) {
            if (cur_k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true; //추가
                backtrack(cur_k - dungeons[i][1], visited, n, dungeons, cnt++);
                visited[i] = false; //빼기
            }
        }


    }
}
