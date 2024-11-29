import java.util.*;

public class Main {
    static long n;
    static long m;
    static long min;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        min = -1;
        n = scan.nextInt();
        m = scan.nextInt();
        dfs(n, 1);
        System.out.println(min);
    }

    private static void dfs(long result, long count) {
        if(result == m) {
            min = Math.max(min, count);
            return;
        }
        if(result * 2 <= m) {
            dfs(result * 2, count + 1);
        } if(10 * result + 1 <= m) {
            dfs(10 * result + 1, count + 1);
        }
    }
}
