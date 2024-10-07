import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;

        final long y = 1000000009;

        for (int i = 7; i < 100001; i++) {
            dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % y;
        }

        for (int t = 0; t < n; t++) {
            int x = Integer.parseInt(br.readLine());
            System.out.println(dp[x]);
        }
    }
}