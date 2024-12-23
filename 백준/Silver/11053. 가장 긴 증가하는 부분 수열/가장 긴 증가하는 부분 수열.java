import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //1.정의 dp[n] n은 배열의 개수, dp[n]은 가장 긴 증가하는 수열의 개수
        int[] dp = new int[n];

        //3. 초기값
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int max = 1;
        //2. 점화식 arr[n] > arr[n-1] 에서 dp[n] = max(dp[n], dp[n-1] + 1) 성립
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}