import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //static StringBuilder sb = new StringBuilder();
    static boolean[] visit; //괄호 체크 배열
    static int[] pair; //괄호 짝
    static char[] arr; //문자열 배열
    static ArrayList<String> answers = new ArrayList<>(); // 정답 문자열

    static TreeSet<String> set;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        arr = n.toCharArray();

        pair = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n.length(); i++) {
            if (arr[i] == '(') {
                // 여는 괄호가 나오면 스택에 넣는다
                stack.push(i);
            } else if (arr[i] == ')') {
                // 닫는 괄호가 나오면 스택의 제일 위 번호를 짝으로 저장하고
                // 거꾸로도 짝으로 저장한다
                pair[i] = stack.peek();
                pair[stack.peek()] = i;
                stack.pop();
            }
        }
        visit = new boolean[arr.length];
        set = new TreeSet<>();
        dfs(0, arr.length);

        set.remove(n);

        StringBuilder sb = new StringBuilder();
        set.stream().forEach(ans -> sb.append(ans).append("\n"));
        System.out.println(sb);

//        Collections.sort(answers);
//        for(int i = 1; i < answers.size(); i++) {
//            System.out.println(answers.get(i));
//        }
    }

    private static void dfs(int i, int len) {
        if(i == len) {
            String ans = "";
            for(int x = 0; x < arr.length; x++) {
                if(!visit[x]) {
                    ans += arr[x];
                }
            }
            //answers.add(ans);
            set.add(ans);
        }else if(arr[i] == '(') { // 닫는 괄호면 방문을 확인
            visit[i] = true;
            visit[pair[i]] = true;
            dfs(i+1, len);
            visit[i] = false;
            visit[pair[i]] = false;
            dfs(i+1, len);
        } else {
            dfs(i+1, len);
        }
    }
}