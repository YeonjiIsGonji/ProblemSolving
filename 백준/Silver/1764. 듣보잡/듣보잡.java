import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        HashSet<String> list = new HashSet<>();

        List<String> name = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            name.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            name.add(br.readLine());
        }

        name.sort(Comparator.naturalOrder());

        for (int i = 0; i < name.size() - 1; i++) {
            if (name.get(i).equals(name.get(i + 1))) {
                list.add(name.get(i));
            }
        }

        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        bw.write(sortedList.size() + "\n");
        for (int i = 0; i < sortedList.size(); i++) {
            bw.write(sortedList.get(i) + "\n");
        }

        bw.flush();
    }
}
