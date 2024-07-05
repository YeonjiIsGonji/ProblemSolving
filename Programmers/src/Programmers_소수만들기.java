public class Programmers_소수만들기 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        int caseCount = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    int measure = 2;
                    while (measure <= num) {
                        if (num % measure == 0) {
                            if (measure != num) {
                                break;
                            } else {
                                caseCount++;
                                break;
                            }
                        } else if(num % measure != 0) {
                            measure++;
                        }
                    }
                }
            }
        }
        System.out.println(caseCount);
    }
}
