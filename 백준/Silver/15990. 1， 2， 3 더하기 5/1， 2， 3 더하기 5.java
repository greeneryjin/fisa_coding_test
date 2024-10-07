import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        final long y = 1000000009;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % y;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % y;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % y;
        }

        for (int t = 0; t < n; t++) {
            int x = Integer.parseInt(br.readLine());
            System.out.println((dp[x][1] + dp[x][2] + dp[x][3])  % y);
        }
    }
}