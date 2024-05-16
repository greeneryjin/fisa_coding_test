import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int distance = 0;
    static int shark = 2;
    static int eat = 0;
    static int inf = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = sc.nextInt();
                if(m == 9){
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = m;
            }
        }
        System.out.println(solve(x, y));
    }

    private static int solve(int x, int y) {

        while (true){
            int[][] distance1 = findDistance(x, y);
            int[] shark1 = getShark(distance1);
            if(shark1[0] == -1){
                break;
            }
            x = shark1[0];
            y = shark1[1];
            distance += distance1[x][y];
            eat++;
            if(shark == eat){
                shark++;
                eat = 0;
            }
            arr[x][y] = 0;
        }
        return distance;
    }

    private static int[][] findDistance(int x, int y) {
        int[][] dis = new int[n][n];
        Queue<Shark> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                dis[i][j] = inf;
        }
        queue.add(new Shark(x, y));
        dis[x][y] = 0;

        while (!queue.isEmpty()){
            Shark poll = queue.poll();
            int bx = poll.x;
            int by = poll.y;

            for (int j = 0; j < 4; j++) {
                int ax = bx + dx[j];
                int ay = by + dy[j];

                if(ax < 0 || ax >= n || ay < 0 || ay >= n || dis[ax][ay] < inf || arr[ax][ay] > shark)
                    continue;
                dis[ax][ay] = dis[bx][by] + 1;
                queue.add(new Shark(ax, ay));
            }
        }
        return dis;
    }

    private static int[] getShark(int[][] dis) {

        int[] result = new int[] {-1, -1};
        int time = inf;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(0 < arr[i][j] && arr[i][j] < shark && time > dis[i][j]){
                    result[0] = i;
                    result[1] = j;
                    time = dis[i][j];
                }
            }
        }
        return result;
    }

    public static class Shark {
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
