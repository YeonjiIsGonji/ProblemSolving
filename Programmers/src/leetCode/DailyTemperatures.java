package leetCode;
import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temps) {
        int[] day = new int[temps.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()]<temps[i]) {
                int prevDay = stack.peek();
                day[prevDay] = i - prevDay;
            }
            stack.push(i);
        }
        return day;
    }


    public static void main(String[] args) {
        int[] temps = {73,74,75};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temps);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
