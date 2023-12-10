import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        String[] arr = n.split("\\.");

        for(int i = 0; i < arr.length; i++) {
            String data = arr[i];
            if(data.length() % 2 == 0) {
                int size = data.length();
                while(size != 0) {
                    if (size >= 4) {
                        sb.append("AAAA");
                        size -= 4;
                    } else if (size >= 2) {
                        sb.append("BB");
                        size -= 2;
                    }
                }
            } else {
                System.out.println(-1);
                return;
            }
            if(i < arr.length - 1) {
                sb.append(".");
            }
        }
        if(sb.length() != n.length()) {
            while(sb.length() + 1 <= n.length()) {
                sb.append(".");
            }
        }
        System.out.println(sb);
    }
}