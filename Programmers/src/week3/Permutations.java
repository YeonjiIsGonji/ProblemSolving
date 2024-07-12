package week3;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList<Integer>(), nums, visited, result);

        return result;
    }

    //순열을 만들어서 result에 추가하는 코드
    void backtrack(List<Integer> curr, int[] nums, boolean[] visited ,List<List<Integer>> result) {
        // basecase
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // recursive call
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            curr.add(nums[i]); // 추가
            visited[i] = true;
            backtrack(curr, nums, visited, result);
            curr.remove(nums[i]); // 제거
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = permutations.permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
