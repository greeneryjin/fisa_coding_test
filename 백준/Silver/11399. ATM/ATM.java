import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int[] arr = new int[n + 1];
        int[] times = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }
        //최소 시간으로 정렬
        Arrays.sort(arr);
        int time = 0;
        for (int i = 1; i <= n; i++) {
            time += arr[i];
            times[i] = time;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += times[i];
        }
        System.out.println(result);
    }
}