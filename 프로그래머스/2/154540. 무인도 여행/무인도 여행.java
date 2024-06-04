import java.util.*;
class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int flag = -1;
    static char[][] arr;
    static boolean[][] copy;
    
    public ArrayList<Integer> solution(String[] maps) {
        int[] answer = {};
        arr = new char[maps.length][maps[0].length()];
        copy = new boolean[maps.length][maps[0].length()];

        for(int i = 0; i < maps.length; i++) {
            String str = maps[i];
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        //무인도 찾기
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                findbfs(arr[i][j], i, j);
            }
        }
        if(flag == -1) {
            list.add(-1);
        }
        Collections.sort(list);
        return list;
    }
public static void findbfs(char c, int ci, int cj) {
        //방문하지 않은 곳만 계산하기
        if(!copy[ci][cj] && arr[ci][cj] != 'X'){
            flag = 0;
            int total = Character.getNumericValue(c);
            Queue<Maze> queue = new LinkedList<>();
            queue.add(new Maze(ci, cj));
            copy[ci][cj] = true;

            while(!queue.isEmpty()) {
                Maze maze = queue.poll();
                int x = maze.x;
                int y = maze.y;

                for(int i = 0; i < 4; i ++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= arr.length || 0 > ny || ny >= arr[0].length) continue;
                    if(!copy[nx][ny] && arr[nx][ny] != 'X'){
                        copy[nx][ny] = true;
                        total += Character.getNumericValue(arr[nx][ny]);
                        queue.add(new Maze(nx, ny));
                    }
                }
            }
            list.add(total);
        }
    }
    public static class Maze {
        int x;
        int y;

        public Maze(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}