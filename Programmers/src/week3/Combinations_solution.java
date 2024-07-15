//package week3;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Combinations_solution {
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> result = new ArrayList<>();
//        backtrack(n, k, new ArrayList<>(), reesult);
//        return result;
//    }
//
//    private void backtrack(int n, int k, List<Integer> curr, List<List<Integer>> result) {
//        // basecase
//        if (curr.size() == k) {
//            result.add(new ArrayList<>(curr));
//            return;
//        }
//        // recursive call
//        for (int i = 1; i <= n; i++) {
//            curr.add(i);
//            backtrack(n, k, curr, result);
//            curr.remove(curr.size()-1);
//        }
//    }
//}
