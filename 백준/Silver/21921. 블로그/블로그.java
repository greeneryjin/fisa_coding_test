import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < x; i++){
            sum += arr[i];
        }
        
        int ans = sum;
        int count = 1;
        for(int i = x; i < n; i++) {
            sum += arr[i] - arr[i - x];
            if(sum > ans) {
                ans = sum;
                count = 1;
            } else if(sum == ans) {
                count++;
            }
        }
        if(ans == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(ans);
            System.out.println(count);
        }
        sc.close();
    }
}