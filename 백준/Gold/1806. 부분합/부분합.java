import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = 1000000;

        int s = 0, e = 0, sum = 0;
        while (true) {
            if(sum >= x) {
                min = Math.min(min, e - s);
                sum -= arr[s++];
            } else if (e == n) {
                break;
            } else {
                sum += arr[e++];
            }
        }
        if(min == 1000000) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}