import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr;         //수
    static int[] Operator; //연산자
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int data = Integer.valueOf(st.nextToken());
            arr[i] = data;
        }

        Operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            int data = Integer.valueOf(st.nextToken());
            Operator[i] = data;
        }
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }


    public static void dfs(int num, int count) {

        if(n == count) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(Operator[i] > 0) {
                Operator[i]--;
                switch(i) {
                    case 0:
                        dfs(num + arr[count], count+1);
                        break;
                    case 1:
                        dfs(num - arr[count], count+1);
                        break;
                    case 2:
                        dfs(num * arr[count], count+1);
                        break;
                    case 3:
                        dfs(num / arr[count], count+1);
                        break;
                }
                Operator[i]++;
            }
        }
    }

    /* 문자열로 저장할 경우 연산자가 1이상일 때 연산자 숫자를 제대로 처리를 못함
     * 연산자 개수를 숫자로 입력 받아서 처리해야 개수대로 연산자를 처리할 수 있음
     * 숫자로 처리하고 배열 내부의 개수를 감소하면서 계산을 함.
     * 연산자로 재귀를 돌려야 dfs로 돌아갈 수 있음 
     * */

}