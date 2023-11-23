
import java.io.*;
import java.util.*;

public class Main { //저장하는 파일 

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{ //실행을 위한 필수 요소
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        

        for(int i = 0 ; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int m = Integer.parseInt(st.nextToken());
        	String text = st.nextToken();
        	
        	for(int x = 0; x < text.length(); x++) {
        		int count = 0;
        		char c = text.charAt(x);
        		
        		for(int j = 0; j < m; j++) {
        			if(count <= m) {
            			sb.append(c);
            			count++;
            		}
        		}
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
    	
    }
}
