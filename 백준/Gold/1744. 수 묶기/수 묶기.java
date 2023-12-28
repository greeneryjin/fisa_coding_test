import java.util.*;
import java.io.*;

/* 1744번 수묶기
 * 가장 큰 값을 구하는 방법
 * 1. 0을 음수로 두고 음수를 더하거나 뺀다.
 * 2. 가장 작은 음수는 더하거나 곱한다.
 * 3. 가장 큰 양수는 곱한다.
 * 
 * 양수와 음수를 가지는 리스트를 생성해서 각각 저장해서 계산하면 끝나는 문제.
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();   
    static ArrayList<Integer> plus = new ArrayList<>();  //양수
    static ArrayList<Integer> minus = new ArrayList<>(); //음수
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); 
        
        for(int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken()); 
            if(data > 0) {
            	plus.add(data);
            }else {
            	minus.add(data);            	
            }
        }
        
        //각각의 양수, 음수 정렬
        Collections.sort(minus);
        Collections.sort(plus, Collections.reverseOrder());

        int i = 0;
        int sum = 0;
        while(i < minus.size()) { //리스트의 원소를 두 개씩 묶어서 계산해야함.  
        	if(i + 1 < minus.size()) { //리스트의 원소는 짝수 or 홀수로 묶어서 할 
        		sum += minus.get(i++) * minus.get(i++);
        	} else {
        		sum += minus.get(i++);
        	}
        }
        
        i = 0;
        while(i < plus.size()) {
        	//1, 2가 있으면 더하는 게 곱하는 것보다 큼. 
        	if(i + 1 < plus.size() && plus.get(i) != 1 && plus.get(i + 1) != 1) { //리스트의 원소는 짝수 or 홀수로 묶어서 할 
        		sum += plus.get(i++) * plus.get(i++);
        	} else {
        		sum += plus.get(i++);
        	}
        }
        System.out.println(sum);
    }
}

