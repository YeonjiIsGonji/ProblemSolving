import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers_피로도 {
    public int solution(int k, int[][] dungeons) {

        List<List<int[]>> ans = new ArrayList<>();
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(n, new ArrayList<>(), dungeons, visited, ans);
        List<Integer> result = new ArrayList<>();

        // 던전 돌기
        // 1. ans[i][j]
        for (List<int[]> per : ans) {
            int hp = k;
            int count = 0;
            for (int[] dungeon : per) {
                if (hp >= dungeon[0]) {
                    hp -= dungeon[1];
                    count++;
                } else {
                    result.add(count);
                    break;
                }
            }
            result.add(count);
        }

        result.sort(Comparator.reverseOrder()); //내림차순 정렬

        return result.get(0);
    }

    private void backtrack(int n, List<int[]> curr, int[][] dungeons, boolean[] visited, List<List<int[]>> ans) {
        if (curr.size() == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;

            curr.add(dungeons[i]);
            visited[i] = true;

            backtrack(n, curr, dungeons, visited, ans);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        Programmers_피로도 ex = new Programmers_피로도();
        System.out.println(ex.solution(k, dungeons));
    }
}
