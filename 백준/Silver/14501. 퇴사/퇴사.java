import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] s;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s =  new int[n][2];

        //상담 일자와 페이를 넣기  
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }
        
        answer = 0;
        dfs(0, 0);
        
        System.out.println(answer);
    }
    
    static void dfs(int day, int pay) {
        if(day >= n) {
            answer = Math.max(pay, answer);
            return;
        }
        
        if(day + s[day][0] <= n) {
            dfs(day + s[day][0], pay + s[day][1]);
        } else {
            dfs(day + s[day][0], pay);
        }
        
        //모든 상담의 경우의 수를 확인 dfs로 돌릴 수 있음 
        dfs(day + 1, pay);
    }
}