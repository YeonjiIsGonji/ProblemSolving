import java.io.*;

public class Main {
    static String[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            if (N == 0) {
                bw.write("-" + "\n");
                continue;
            }
            int size = (int) Math.pow(3, N);
            array = new String[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = "-";
            }
            func(0, size);
            for (int i = 0; i < size; i++) {
                bw.write(array[i]);
            }
            bw.newLine();
            bw.flush();

        }
    }

    public static void func(int start, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;
        for (int i = start + newSize; i < start + newSize * 2; i++) {
            array[i] = " ";
        }

        func(start, newSize);
        func(start + newSize * 2, newSize);
    }
}
