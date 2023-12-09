import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    //dfs
    static boolean visit[]; // dfs 방문 확인
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); //인접 리스트
    static int total;

    //bfs
    static Queue<Integer> queue = new LinkedList<>();
    static boolean visit2[];


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int v = Integer.valueOf(st.nextToken());
        int s = Integer.valueOf(st.nextToken());

        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(arr.get(i));
        }
        total = n;
        visit = new boolean[n + 1];
        dfs(s);
        sb.append('\n');

        visit2 = new boolean[n + 1];
        bfs(s);
        System.out.println(sb);
    }

    private static void bfs(int x) {

        queue.add(x);
        visit2[x] = true;
        sb.append(x).append(' ');

        while(!queue.isEmpty()) {
            int now = queue.poll();
            int len = arr.get(now).size();

            for(int i = 0; i < len; i++) {
                int next = arr.get(now).get(i);

                if(!visit2[next]) {
                    visit2[next] = true;
                    sb.append(next).append(' ');
                    queue.add(next);
                }
            }
        }
    }

    private static void dfs(int s) {

        visit[s] = true;
        sb.append(s).append(' ');
        for(int num : arr.get(s)) {
            if(!visit[num]) {
                dfs(num);
            }
        }
    }
}