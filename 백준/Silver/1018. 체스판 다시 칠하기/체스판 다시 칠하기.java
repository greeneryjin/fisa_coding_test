import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String s = st1.nextToken();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        //자르기(8을 벗어날 수 없음)
        int count = 64;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                count = Math.min(count, fun(i, j));
            }
        }
        System.out.println(count);
    }

    //0 ~ n, 0 ~ m 범위에서 8까지 갈 수 있는 곳
    private static int fun(int x, int y) {
        int count = 0;
        char color = 'W'; // 첫번째 칸을 W를 기준으로 색칠

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // color는 정상적인 체스판이고 WB[i][j]와 비교
                if(map[i][j] == color) {
                    count++;
                } if(color == 'W') {
                    color = 'B';
                } else {
                    color = 'W';
                }
            }
            // 다음칸이랑 색상이 달라야 한다.
            if(color == 'W') {
                color = 'B';
            } else {
                color = 'W';
            }
        }
        count = Math.min(count, 64 - count);
        return count;
    }
}