package week3;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        int[] num = new int[n];

        // 1 ~ n 까지 배열
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }

        // result 세팅
        for (List<Integer> list : result) {
            result.add(new ArrayList<>());
        }
        ArrayList<Integer> com = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                com.add(i);
            }

        }

        return result;
    }


}
