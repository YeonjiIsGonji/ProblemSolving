import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        int[][] graph = new int[N][M];
        int[][] visited = new int[N][M];
        int count = 0;

        // 그래프 만들기
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] arr = input.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                graph[i][j] = Character.getNumericValue(arr[j]);
            }
        }

        // 그래프 탐색
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();
            int currN = currNode[0];
            int currM = currNode[1];
            
            // 현재 노드에서 위로 이동
            if (currM >= 1 && visited[currN][currM - 1] == 0 && graph[currN][currM - 1] == 1) {
                queue.add(new int[]{currN, currM - 1});
                visited[currN][currM - 1] = visited[currN][currM] + 1;
            }
            
            // 현재 노드에서 아래로 이동
            if (currM <= M - 2 && visited[currN][currM + 1] == 0 && graph[currN][currM + 1] == 1) {
                queue.add(new int[]{currN, currM + 1});
                visited[currN][currM + 1] = visited[currN][currM] + 1;
            }
        
            // 현재 노드에서 왼쪽으로 이동
            if (currN >= 1 && visited[currN - 1][currM] == 0 && graph[currN - 1][currM] == 1) {
                queue.add(new int[]{currN - 1, currM});
                visited[currN - 1][currM] = visited[currN][currM] + 1;
            }
    
            // 현재 노드에서 오른쪽으로 이동
            if (currN <= N - 2 && visited[currN + 1][currM] == 0 && graph[currN + 1][currM] == 1) {
                queue.add(new int[]{currN + 1, currM});
                visited[currN + 1][currM] = visited[currN][currM] + 1;
            }

        }
        System.out.println(visited[N - 1][M - 1]);
    }

}
