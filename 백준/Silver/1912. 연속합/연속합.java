import java.util.*;
import java.io.*;

/* 
 * 1912번 연속합
 * dp 문제로 max 함수를 사용해서 기존 앞의 계산한 값과 현재값을 더한 결과 값을 현재 값과 비교해서
 * 더 큰 값을 넣으면 되는 문제.
 * 현재 값이 더 클 경우는 기존 앞에서 더한 값을 사용하지 않고 새로운 값을 사용하는 의미
 * 2 1 -4 3 4 -4 6 5 -5 1
 * 여기에서는 2~3까지의 결과값이 현재 3보다 작기 때문에 3부터 새롭게 계산하는 의미. 
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();   

    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); 
        int[] arr = new int[x]; //들어온 값 저장 
        int[] dp = new int[x]; //연속합의 결과를 저장
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < x; i++) {
        	int data = Integer.parseInt(st.nextToken()); 
        	arr[i] = data;
        }
        
        dp[0] = arr[0];
        int max = arr[0];
        
        for(int i = 1; i < x; i++) {
        	dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        	max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}