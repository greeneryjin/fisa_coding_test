import java.util.*;
import java.io.*;

/* 
 * 1026번 보물
 * A는 가장 작게 정렬
 * B는 가장 크게 정렬
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();   
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); 

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < x; i++) {
        	int data = Integer.parseInt(st.nextToken()); 
        	arr1.add(data);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < x; i++) {
        	int data = Integer.parseInt(st.nextToken()); 
        	arr2.add(data);
        }
        
        Collections.sort(arr1);
        Collections.sort(arr2, Collections.reverseOrder());
        
        int sum = 0;
        for(int i = 0; i < x; i++) {
        	sum += arr1.get(i) * arr2.get(i);
        }
        
        System.out.println(sum);
    }
}

