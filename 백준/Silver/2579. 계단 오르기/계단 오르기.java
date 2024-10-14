import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        // 계단이 1개 이하일 경우 처리
        if (n == 1) {
            int t = Integer.parseInt(br.readLine());
            System.out.println(t);
            return;
        }

        //정의
        int[][] dp = new int[n + 1][3];
        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            int t = Integer.parseInt(br.readLine());
            arr[i] = t;
        }

        //초기값
        dp[1][1] = arr[1];
        dp[1][2] = Integer.MIN_VALUE;

        dp[2][1] = arr[2];
        dp[2][2] = arr[1] + arr[2];

        //점화식
        for (int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }

        int result = Math.max(dp[n][1], dp[n][2]);
        System.out.println(result);
    }
}