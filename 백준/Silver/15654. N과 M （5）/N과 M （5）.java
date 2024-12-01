
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visit = new boolean[n];
        answer = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb.toString());
    }

    public static void dfs(int f) {
        if(m == f) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                answer[f] = arr[i];
                dfs(f + 1);
                visit[i] = false;
            }
        }
    }
}