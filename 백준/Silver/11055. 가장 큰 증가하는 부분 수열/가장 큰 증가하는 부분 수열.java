import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }
        int answer = dp[0];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(arr[i] + dp[j], dp[i]);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        System.out.println(answer);
    }
}