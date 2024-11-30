import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] answer;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st1.nextToken());
                if(x == 2) {
                    queue.add(new Node(i, j));
                    visit[i][j] = true;
                    answer[i][j] = 0;
                } else if(x == 0) {
                    visit[i][j] = true;
                }
                map[i][j] = x;
            }
        }
        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    if(!visit[i][j]) { // 도달할 수 없는 위치
                        answer[i][j] = -1;
                    }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void bfs() {

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = poll.x + dx[k];
                int ny = poll.y + dy[k];

                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(!visit[nx][ny] && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                        answer[nx][ny] = answer[poll.x][poll.y] + 1;
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}