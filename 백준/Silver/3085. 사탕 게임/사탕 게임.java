import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int[] x = {0, 1};
    static int [] y = {1, 0};
    static char[][] arr;

    static char[][] copy;

    //옆으로 읽는 배열
    static int[] color1;

    //위로 읽는 배열
    static int[] color2;

    static int n;

    static int max = Integer.MIN_VALUE;

    static int answer1 = Integer.MIN_VALUE;

    static int answer2 = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n + 1][n + 1];
        copy = new char[n + 1][n + 1];
        color1 = new int[n + 1];
        color2 = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        //copy 배열 복사
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                changeFun(i, j);
            }
        }
        System.out.print(max);
    }
    //위치를 변경하는 함수
    public static void changeFun(int z, int t) {

        //인접한 위치를 찾는 함수
        for(int w = 0; w < x.length; w++) {
            int a = z + x[w];
            int b = t + y[w];

            if(1 <= a && a <= n && 1 <= b && b <= n){
                if(!(copy[z][t] == copy[a][b])){
                    //인접한 곳을 위치 변경
                    copy[a][b] = arr[z][t];
                    copy[z][t] = arr[a][b];
                    findMax();
                    //변경했던 위치를 롤백
                    copy[a][b] = arr[a][b];
                    copy[z][t] = arr[z][t];
                }
            }
        }
    }

    //색상의 개수를 찾기
    public static void findMax() {
        int tmp = 1;
        //옆으로 읽기
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < n; j++) {
                color1[1] = tmp;
               if(copy[i][j] == copy[i][j + 1]){
                   tmp++;
                   color1[j+1] = tmp;
               } else {
                   tmp = 1;
                   color1[j+1] = tmp;
               }
                answer1 = Math.max(answer1, color1[j+1]);
            }
            tmp = 1;
        }

        //위로 읽기
        tmp = 1;
        for(int i = 1; i <= n; i++) {
            color2[1] = tmp;
            for(int j = 1; j < n; j++) {
                if(copy[j][i] == copy[j + 1][i]){
                    tmp++;
                    color2[j + 1] = tmp;
                } else {
                    tmp = 1;
                    color2[j + 1] = tmp;
                }
                answer2 = Math.max(answer2, color2[j+1]);
            }
            tmp = 1;
        }
        max = Math.max(answer1, answer2);
    }
}