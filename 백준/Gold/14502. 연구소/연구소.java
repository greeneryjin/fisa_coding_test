import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxSafeZone = Integer.MIN_VALUE;
    static int n;
    static int m;
    static int[][] arr;

    //벽을 세우기 위해 모든 경우의 수를 따져보기
    private static void dfs(int wall) {
        if(wall == 3){
            findVirus(arr);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    //지나온 곳을 다시 안간 곳으로 돌려서 다른 곳도 방문할 수 있게 만들기
                    arr[i][j] = 0;
                }
            }
        }
    }

    //바이러스를 전파하고 최댓값 찾기
    public static void findVirus(int[][] dis) {
        int[][] vir = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        //바이러스 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vir[i][j] = dis[i][j];
            }
        }

        //현재 바이러스 위치를 큐에 넣음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vir[i][j] == 2){
                    q.add(new int[] {i, j});
                }
            }
        }

        //현재 위치에서 바이러스 전파
        while (!q.isEmpty()){
            int[] pos = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(vir[nx][ny] == 0) {
                        vir[nx][ny] = 2;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        int result = 0;
        //안전 영역 개수 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vir[i][j] == 0) {
                    result++;
                }
            }
        }
        //최대값을 찾기
        if (maxSafeZone < result) {
            maxSafeZone = result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);
        sc.close();
    }
}
