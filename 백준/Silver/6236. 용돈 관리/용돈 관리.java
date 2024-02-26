import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Integer.max(max, arr[i]);
        }

        //최소 인출 금액 하루 쓸 돈보다 무조건 커야함
        int lt = max;
        //최대 인출 금액( 100000명이 한 번에 10000을 뽑을 수 있다.)
        int rt = 100000 * 10000;
        int answer = 0;

        while (lt <= rt) {
            //평균 인출 금액
            int mid = (lt + rt) / 2;
            // 인출 횟수 - 첫 평균 값을 인출 최소값으로 설정함
            int count = 1;
            //인출한 돈과 뺀 돈이 남았을 경우 저장
            int leftMoney = mid;

            //평균 인출 값이 정해지면 인출 횟수를 정함
            for (int i = 0; i < n; i++) {
                if (arr[i] <= leftMoney) {
                    leftMoney -= arr[i];
                } else {
                    //(무조건 큰 값을 했기 때문에 쓸 돈이 인출 금액보다 작을 수는 없음)
                    //다시 인출해서 횟수를 셈
                    leftMoney = mid - arr[i];
                    count++;
                }
            }
            //인출 금액이 너무 작아서 인출 횟수를 늘린 것.
            if (count > c) {
                lt = mid + 1;
            }
            //인출 금액이 너무 커서 인출 횟수가 기준값보다 작은 것.
            else{
                rt = mid - 1;
                answer = rt;
            }
        }
        System.out.println(answer + 1);
    }
}