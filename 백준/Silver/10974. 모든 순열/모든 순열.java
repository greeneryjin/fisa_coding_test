import java.util.*;
import java.io.*;

/*
 * 
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int [] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        visit = new boolean[n];
        arr = new int[n];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int x) {

        if(x == n) {
            for(int i  = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        else{
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    continue;
                }
                arr[x] = i + 1;
                visit[i] = true;
                dfs(x + 1);
                visit[i] = false;
            }
        }
    }
}
