import java.util.Arrays;

public class Programmers_예산 {
    public static void main(String[] args) {
        int[] num = {2,2,3,3};
        int budget = 7;
        int count = 0;
        int sum = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            if (sum <= budget) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
