import java.util.*;
import java.io.*;

/* 
 * 2839번 
 * 설탕 배달
 * 
 * * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 

        int five = 0;
        int three = 0;
        
        while(n % 5 != 0) {
        	n -= 3;
        	three++;
        	if(n < 0) {
        		System.out.println(-1);
        		return;
        	}
        }
        five = n / 5;
        System.out.println(five + three);
    }
}