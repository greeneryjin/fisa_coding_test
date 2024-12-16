import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }
        dfs(0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int x, int y, int size) {
        if(size == 1) {
            arr[x][y] = '*';
            return;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(!(i == 1 && j == 1)) {
                        dfs(x + i * size / 3, y + j * size / 3, size / 3);
                    }
                }
            }
        }
    }
}