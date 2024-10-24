import java.util.*;

public class Main {
    static int sheepTotal, wolfTotal;
    static int n;
    static int m;
    static char[][] maze; //접근 확인 이차원 배열
    static boolean[][] visit; // 방문을 확인하는 이차원 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Step> q = new LinkedList<>();
    static List<Integer> complexSizes = new ArrayList<>(); // 각 영역별 살아남은 동물 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        maze = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((maze[i][j] == 'o' || maze[i][j] == 'v' || maze[i][j] == '.') && !visit[i][j]) {
                     bfs(i, j);
                 }
            }
        }

        // 결과 출력
        System.out.print(sheepTotal + " " + wolfTotal);
    }

    private static void bfs(int i, int j) {
        visit[i][j] = true;
        q.add(new Step(i, j));

        int sheep = 0; // 현재 영역의 양의 수
        int wolves = 0; // 현재 영역의 늑대의 수

        // 현재 위치에 양 또는 늑대가 있으면 카운트
        if (maze[i][j] == 'o') sheep++;
        if (maze[i][j] == 'v') wolves++;

        while (!q.isEmpty()) {
            Step poll = q.poll();

            for (int x = 0; x < 4; x++) {
                int nextX = poll.x + dx[x];
                int nextY = poll.y + dy[x];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                    if(maze[nextX][nextY] == '.' && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        q.add(new Step(nextX, nextY));
                    }

                    if(maze[nextX][nextY] == 'o' && !visit[nextX][nextY]) {
                        sheep++;
                        visit[nextX][nextY] = true;
                        q.add(new Step(nextX, nextY));
                    }

                    if(maze[nextX][nextY] == 'v' && !visit[nextX][nextY]) {
                        wolves++;
                        visit[nextX][nextY] = true;
                        q.add(new Step(nextX, nextY));
                    }
                }
            }
        }
        if(sheep > wolves) {
            sheepTotal += sheep;
        }
        else {
            wolfTotal += wolves;
        }
    }

    public static class Step {
        int x;
        int y;

        public Step(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}