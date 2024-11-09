import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] check;
    static int m = 3;
    static int k;
    static int n;
    static int sum;
    static int score = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(score);
    }
    private static void dfs(int s, int f) {
        if(f == m) {
            if(k >= sum) {
                score = Math.max(score, sum);
            }
            return;
        }
        for (int i = s; i < n; i++) {
            if(!check[i]) {
                check[i] = true;
                sum += arr[i];
                dfs(s + 1, f + 1);
                sum -= arr[i];
                check[i] = false;
            }
        }
    }
}