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


        for (int i = 0; i < n; i++) {
            for (int j = n - 1 - i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("*");

            if(i >= 1) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}