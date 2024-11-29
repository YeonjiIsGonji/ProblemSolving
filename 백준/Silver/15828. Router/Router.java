import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bufferSize = Integer.parseInt(br.readLine());
        Queue<Integer> router = new LinkedList<>();
        while (true) {
            int data = Integer.parseInt(br.readLine());
            if (data == -1) {
                break;
            }
            router.add(data);
        }
        Queue<Integer> buffer = transaction(router, bufferSize);

        if (buffer.isEmpty()) {
            System.out.println("empty");
        }

        for (Integer data : buffer) {
            System.out.print(data + " ");
        }
    }

    public static Queue<Integer> transaction(Queue<Integer> router, int bufferSize) {
        Queue<Integer> buffer = new LinkedList<>();
        int bufferAvailableSize = bufferSize;
        while (!router.isEmpty()) {
            int data = router.poll();
            if (data == 0) {
                buffer.poll();
                bufferAvailableSize++;
            } else if (bufferAvailableSize > 0) {
                buffer.add(data);
                bufferAvailableSize--;
            }
        }
        return buffer;
    }
}
