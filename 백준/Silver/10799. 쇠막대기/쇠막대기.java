import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int count = 0;
        int sum = 0;
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) == '(') {
                stack.add(n.charAt(i));
            } else {
                stack.pop();
                    //문자열의 전의 ( 괄호가 나와야 ) 레이져 완성.
//                    if(stack.peek() == '(') {
//                        sum += stack.size();
//                    }else {
//                        sum++;
//                    }
                if(n.charAt(i-1) == '(') {   //바꾼 부분!!!!
                    //stack.peek()는 항상 "("이라서 이전 코드에서는 항상 이게 참이었어요. 그래서 값이 크게 나왔어요!
                    //처음 주어진 String n에서의 이전 인덱스를 확인해야 쇠막대기가 끝나는 건지, 아니면 레이저인지 알 수 있어요.
                    //이전 값이 "("면 레이저고, 이전 값이 ")"면 쇠막대기가 끝나는 곳이에요.
                    sum += stack.size();
                }else {
                    //이 경우는 쇠막대기가 끝나는 부분이라서 sum++만 해줘요.
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}