import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static char[][] mapColor;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int color;
    static int noColor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        color = 0;
        noColor = 0;

        map = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String s = st1.nextToken();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }
        //정상
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j]) {
                    color++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
        visit = new boolean[n][n];

        //비정상으로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j]) {
                    noColor++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(color + " " + noColor);
    }
    private static void dfs(int x, int y, char ch) {

        if(visit[x][y]) {
            return;
        } else {
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if(!visit[nx][ny] && map[nx][ny] == ch) {
                        dfs(nx, ny, ch);
                    }
                }
            }
        }
    }
}