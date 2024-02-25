import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
	      st = new StringTokenizer(br.readLine());
	      int n = Integer.parseInt(st.nextToken());
	      int m = Integer.parseInt(st.nextToken());
	      int[] arr = new int[n];
	      
	      st = new StringTokenizer(br.readLine());
	      for(int i = 0; i < n; i++) {
	    	  int data = Integer.parseInt(st.nextToken());
	    	  arr[i] = data;
	      }
	      
	      Arrays.sort(arr);
	      
	      long lt = 0;
	      long rt = arr[n-1];
	      while(lt <= rt) {
	    	  long sum = 0;
	    	  long mid = (lt + rt) / 2;
	    
	    	  for(int i = 0; i < arr.length; i++) {
	    		  if(arr[i] > mid) {
	    			  sum += arr[i] - mid; 			  
	    		  }
	    	  }
	    	 if(sum >= m) {
	    		  lt = mid + 1;
	    	  } else {
	    		  rt = mid - 1;
	    	  }
	      }
	      System.out.println(rt);
	}
}