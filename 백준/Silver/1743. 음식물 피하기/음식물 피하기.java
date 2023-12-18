import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[][] visit;
    static int N;
    static int M;
    static int[] l = {0, 1, 0, -1};
    static int [] r = {1, 0, -1, 0};

    static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로
        int X = Integer.parseInt(st.nextToken()); //쓰레기 위치

        arr = new int[N + 1][M + 1]; //쓰레기의 개수를 담는 배열
        visit = new boolean[N + 1][M + 1];
        count = 0; //쓰레기의 크기

        for(int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            visit[r][c] = true;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < M + 1; j++) {
                if(visit[i][j]) { //쓰레기 위치
                    dfs(i, j);
                    ans = Math.max(ans, count);
                    count = 0;
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {

        count++;
        visit[x][y] = false;

        for(int i = 0; i < 4; i++) {
            int nextL = l[i] + x;
            int nextR = r[i] + y;

            if(0 <= nextL && nextL <= N && 0 <= nextR && nextR <= M) {

                if(visit[nextL][nextR]) {
                    dfs(nextL, nextR);
                }
            }
        }
    }
}