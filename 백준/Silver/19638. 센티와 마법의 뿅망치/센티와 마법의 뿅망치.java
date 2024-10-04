import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 거인 수
        int h = Integer.parseInt(st.nextToken()); // 센티의 키
        int t = Integer.parseInt(st.nextToken()); // 뿅망치 사용 횟수

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 거인의 키 입력 처리
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int useCount = 0; // 뿅망치 사용 횟수 카운트

        // 최대 t번 뿅망치 사용
        while (useCount < t && pq.peek() >= h) {
            int tallest = pq.poll();

            // 거인의 키가 1이면 더 이상 줄일 수 없음
            if (tallest == 1) {
                pq.add(tallest);
                break;
            }

            // 뿅망치 사용: 키를 반으로 줄이고 다시 큐에 삽입
            pq.add(tallest / 2);
            useCount++;
        }

        // 모든 뿅망치 사용 후 가장 큰 거인의 키 확인
        if (pq.peek() >= h) {
            System.out.println("NO");
            System.out.println(pq.peek()); // 가장 큰 키 출력
        } else {
            System.out.println("YES");
            System.out.println(useCount); // 사용한 뿅망치 횟수 출력
        }
    }
}