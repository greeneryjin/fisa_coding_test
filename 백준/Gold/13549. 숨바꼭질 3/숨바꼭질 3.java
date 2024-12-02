import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visit;
    static Queue<Step> queue = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        queue.add(new Step(n, 0));
        while (!queue.isEmpty()) {
            Step poll = queue.poll();
            visit[poll.score] = true;

            if(poll.score == m) {
                answer = Math.min(answer, poll.time);
            }

            if(poll.score - 1 >= 0 && !visit[poll.score - 1]) {
                queue.add(new Step(poll.score - 1, poll.time + 1));
            } if (poll.score + 1 <= 100000 && !visit[poll.score + 1]) {
                queue.add(new Step(poll.score + 1, poll.time + 1));
            } if (poll.score * 2 <= 100000 && !visit[poll.score * 2]) {
                queue.add(new Step(poll.score * 2, poll.time));
            }
        }
    }

    public static class Step {
        int score;
        int time;
        public Step(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}