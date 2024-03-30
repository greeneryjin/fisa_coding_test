import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] lpoint = new int[n];
        int[] rpoint = new int[n];

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if(arr.length == 1){
            System.out.print(1);
        } else {
            lpoint[0] = 0;
            rpoint[n - 1] = 0;

            //왼쪽으로 읽기
            int lcount = 1;
            for(int i = 0; i < n - 1; i++) {
                if(arr[i] <= arr[i+1]) {
                    lcount++;
                    lpoint[i + 1] = lcount;
                } else {
                    lcount = 1;
                    lpoint[i + 1] = lcount;
                }
            }

            //오른쪽을 읽기
            int rcount = 1;
            for(int i = n - 1; i > 0; i--) {
                if(arr[i - 1] >= arr[i]) {
                    rcount++;
                    rpoint[i - 1] = rcount;
                } else {
                    rcount = 1;
                    rpoint[i - 1] = rcount;
                }
            }
            int lmax = -1;
            for(int i = 0; i < lpoint.length; i++) {
                if(lmax < lpoint[i]){
                    lmax = lpoint[i];
                }
            }

            int rmax = -1;
            for(int i = 0; i < rpoint.length; i++) {
                if(rmax < rpoint[i]){
                    rmax = rpoint[i];
                }
            }
            int answer = 0;
            if(lmax > rmax){
                answer = lmax;
            } else{
                answer = rmax;
            }
            if(answer > 2) {
                System.out.print(answer);
            } else{
                System.out.print(2);
            }
        }
    }
}