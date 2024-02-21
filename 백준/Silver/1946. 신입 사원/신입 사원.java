import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            ArrayList<employee> e = new ArrayList<>();
            int index = Integer.parseInt(br.readLine());

            for (int j = 0; j < index; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                e.add(new employee(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(e);
            int rank = findRank(e);
            System.out.println(rank);
        }
    }

    public static int findRank(ArrayList<employee> e){

        int count = 1;
        int min = e.get(0).y;
        for(int i = 1; i < e.size(); i++) {
            if(e.get(i).y < min){
                count++;
                min = e.get(i).y;
            }
        }
        return count;
    }

    public static class employee implements Comparable<employee> {
        int x;
        int y;
        employee(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(employee o) {
            return this.x - o.x;
        }
    }
}