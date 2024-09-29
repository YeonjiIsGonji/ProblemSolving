import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();
        int[] numArr = new int[10];

        for (int i = 0; i < roomNumber.length(); i++) {
            int num = Integer.parseInt(String.valueOf(roomNumber.charAt(i)));
            numArr[num]++;
        }

        int sum = numArr[6] + numArr[9];
        if (sum >= 2) {
            if (sum % 2 == 0) {
                numArr[6] = sum / 2;
                numArr[9] = sum / 2;
            } else {
                numArr[6] = (sum / 2) + 1;
                numArr[9] = (sum / 2) + 1;
            }
        }

        Arrays.sort(numArr);
        System.out.println(numArr[9]);
    }
}
