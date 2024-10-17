import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        // 각 날에 사용할 금액 입력
        int maxAmount = 0;
        int totalAmount = 100000 * 10000;;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            maxAmount = Math.max(maxAmount, arr[i]); // 하루에 사용할 금액 중 가장 큰 값
        }

        // 이분 탐색 범위 설정
        long left = maxAmount;  // 최소 인출 금액은 하루에 필요한 최대 금액 이상이어야 함
        long right = totalAmount;  // 최대 인출 금액은 모든 금액의 합
        long result = totalAmount; // 최소 인출 금액을 저장할 변수

        while (left <= right) {
            long mid = (left + right) / 2; // 현재 중간값 (인출 금액 후보)
            long currentAmount = 0;
            int count = 1;  // 첫 번째 인출

            for (int i = 0; i < arr.length; i++) {
                if (currentAmount + arr[i] > mid) {
                    count++;
                    currentAmount = arr[i];
                } else {
                    currentAmount += arr[i];
                }
            }
            if (count <= k) {
                // 인출 횟수가 M번 이하로 가능하면 인출 금액을 줄여볼 수 있음
                result = mid;
                right = mid - 1;
            } else {
                // 인출 횟수가 M번보다 크다면 인출 금액을 늘려야 함
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}