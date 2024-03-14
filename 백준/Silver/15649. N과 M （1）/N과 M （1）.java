import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n;
    static int s;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[s];
        visit = new boolean[n + 1];
        dfs(0);
    }

    public static void dfs(int v){

        if(s == v) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[v] = i + 1;
                dfs(v + 1);
                visit[i] = false;
            }
        }
    }
}