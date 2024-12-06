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

        int index = (n * 2) - 1;

        for (int i = 0; i < n; i++) {

            // 짝수 행
            if(i % 2 == 0){
                for(int j = 0; j < index; j++){
                    if(j % 2 == 0) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            // 홀수 행
            else{
                for(int j = 0; j <= index + 1; j++){
                    if(j % 2 == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }
}