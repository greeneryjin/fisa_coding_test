import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            sum[i] += arr[i] + sum[i - 1];
        }
        int m = scanner.nextInt();
        for(int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(sum[b] - sum[a - 1]);
        }
    }
}