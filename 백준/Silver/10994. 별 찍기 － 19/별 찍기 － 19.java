import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = (n * 4) - 3;
        star = new char[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                star[i][j] = ' ';
            }
        }

        dfs(0, len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }
    public static void dfs(int s, int l) {

        if(l <= s) {
            return;
        }
        for (int i = s; i < l; i++) {
            star[s][i] = '*';
            star[l - 1][i] = '*';
            star[i][s] = '*';
            star[i][l - 1] = '*';
        }
        dfs(s + 2, l - 2);
    }
}