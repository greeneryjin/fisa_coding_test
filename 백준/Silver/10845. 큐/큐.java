import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        LinkedList<String> s = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(bf.readLine());
            String m = st.nextToken();

            if(m.equals("push")){
                s.offer(st.nextToken());
            }

            else if (m.equals("pop")) {
                if(s.isEmpty()){
                    System.out.println("-1");
                } else{
                    System.out.println(s.poll());
                }
            }

            else if(m.equals("size")) {
                System.out.println(s.size());
            }

            else if(m.equals("empty")){
                if(s.isEmpty()){
                    System.out.println("1");
                } else{
                    System.out.println("0");
                }
            }

            else if(m.equals("front")){
                if(s.isEmpty()){
                    System.out.println("-1");
                } else{
                    System.out.println(s.getFirst());
                }
            }

            else if(m.equals("back")){
                if(s.isEmpty()){
                    System.out.println("-1");
                } else{
                    System.out.println(s.getLast());
                }
            }
        }

    }
}