import java.util.*;

public class Main {
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            k = sc.nextInt();
            if(k == 0) {
                if(pq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                for (int j = 0; j < k; j++) {
                    int x = sc.nextInt();
                    pq.offer(x);
                }
            }
        }
    }
}