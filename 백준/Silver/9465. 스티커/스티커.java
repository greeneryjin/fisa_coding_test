import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        for (int x = 0; x < s1; x++) {
            int s2 = sc.nextInt();
            int [][] arr = new int[2][s2 + 1];
            int [][] dp = new int[2][s2 + 1];

            for(int i = 0; i < 2; i++){
                for (int j = 1; j <= s2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            /** arr
             *   0  1  2  3  4  5
             * 0 0 50 10 100 20 40
             * 1 0 30 50  70 10 60
             * */

            /** arr
             *   0  1  2  3  4  5
             * 0 0 50  0  0  0  0
             * 1 0 30  0  0  0  0
             * */
            //dp를 시작해서 값을 저장
            for (int j = 2; j <= s2; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][s2], dp[1][s2]));
        }
    }
}