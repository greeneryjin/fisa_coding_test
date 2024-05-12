import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = arr[i] + dp[i - 1];
        }

        for (int i = 1; i <= x; i++) {
            int z = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(dp[y] - dp[z - 1]);
        }
    }
}