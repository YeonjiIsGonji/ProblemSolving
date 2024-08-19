package week3;

import java.util.ArrayList;
import java.util.List;

class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> answer = new ArrayList<>();

        backtracking(n, k, nums, new ArrayList<>(), 0, visited, answer);

        return answer;
    }

    public static void backtracking(int n, int k, int[] nums, List<Integer> comb, int start, boolean[] visited, List<List<Integer>> answer) {
        if (comb.size() == k) {
            answer.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < n; i++) {
            if (visited[i]) continue;
            comb.add(nums[i]);
            visited[i] = true;
            backtracking(n, k, nums, comb, i + 1, visited, answer);
            visited[i] = false;
            comb.remove(comb.size() - 1);

        }
    }
}