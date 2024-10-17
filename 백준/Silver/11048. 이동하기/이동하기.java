import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n][m]; // dp 배열
        int[][] candy = new int[n][m]; // 사탕 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                candy[i][j] = sc.nextInt();
            }
        }

        //초기값
        dp[0][0] = candy[0][0];

        // 첫 번째 행
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + candy[0][j];
        }

        // 첫 번째 열
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + candy[i][0];
        }

        //점화식
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1])) + candy[i][j];
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}