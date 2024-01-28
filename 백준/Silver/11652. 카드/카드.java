import java.util.*;

import static java.lang.Math.max;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i ++) {
            Long data = sc.nextLong();
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        //가장 큰 값 찾기
        for (Long key: map.keySet()) {
            int value = map.get(key);
            max = Math.max(max, value);
        }
        
        //큰 값이 같으면 가장 작은 거 출력
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (Long key: map.keySet()) {
            //가장 큰 값
           if(max == map.get(key)){
               q.add(key);
           }
        }

        System.out.println(q.poll());
        sc.close();
    }
}
