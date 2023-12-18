import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int x = 0;
    static int dp[] = new int [11];
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
        	dps(data);
        }
    }

	private static void dps(int data) {
        for(int i = 4; i <= 10; i++) {
        	dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        
        System.out.println(dp[data]);
	}
}