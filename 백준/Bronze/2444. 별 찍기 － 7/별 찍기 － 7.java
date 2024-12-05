import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int x = 1;
        for (int i = 0; i < n - 1; i++) {

            for (int j = i; j < n - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i + x; j++) {
                System.out.print("*");
            }
            x++;
            System.out.println();
        }
        int y = n - 1;
        int z = 0;
        for (int i = n; i > 0; i--) {

            for (int j = 0; j < z; j++) {
                System.out.print(" ");
            }
            z++;

            for (int j = 0; j < i + y; j++) {
                System.out.print("*");
            }
            y--;
            System.out.println();
        }
    }
}