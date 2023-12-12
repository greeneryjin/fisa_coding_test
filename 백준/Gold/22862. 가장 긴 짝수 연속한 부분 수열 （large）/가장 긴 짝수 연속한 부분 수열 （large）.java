import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[x];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < x; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int lt = 0, rt = 0, cnt = 0, ans = -1;
        while(true) {
        	
        	if(rt == arr.length) {
        		break;
        	}
        	
            if(cnt > k) {
            	if(arr[lt] % 2 != 0) {
                    cnt--;
                }
            	lt++;

            } if(cnt <= k) {
                if(arr[rt] % 2 != 0) {
                    cnt++;
                }
                rt++;
            }
            
            if(cnt <= k) {
                ans = Math.max(ans, rt - lt - cnt);
            }
            
        }
        System.out.println(ans);
    }
    
}