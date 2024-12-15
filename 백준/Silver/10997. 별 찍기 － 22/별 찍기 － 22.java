import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t = 0;
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = n * 4 - 3;
        int c = n * 4 - 1;

        if (n == 1) {
            System.out.print("*");
            return;
        }else {
            star = new char[c][w];
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < w; j++) {
                star[i][j] = ' ';
            }
        }

        dfs(0, c - 1, w - 1, n);
        System.out.print(print(star));
    }
    public static void dfs(int top, int bottom, int x, int f) {
        if(f == 1) {
            star[0][0] = '*';
            return;
        } else {
            //위쪽
            if(t != 0) {
                star[top][x + 1] = '*';
            }
            for (int i = t; i <= x; i++) {
                star[top][i] = '*';
            }
            //아래
            for (int i = t; i <= x; i++) {
                star[bottom][i] = '*';
            }
            //왼
            for (int i = t; i <= bottom; i++) {
                star[i][t] = '*';
            }
            //오른
            for (int i = t + 2; i <= bottom; i++) {
                star[i][x] = '*';
            }
            t += 2;

            if(f == 2) {
                star[top + 2][x - 1] = '*';
                star[top + 2][x - 2] = '*';
                star[top + 3][x - 2] = '*';
                star[top + 4][x - 2] = '*';
            }

            dfs(top + 2, bottom - 2, x - 2, f - 1);
        }
    }
    static StringBuilder print(char[][] star) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < star.length; i++) {
            for (int j = 0; j < star[0].length; j++) {
                if (i==1 && j==0) {
                    sb.append(star[i][j]);
                    break;
                }
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }
        return sb;
    }
}