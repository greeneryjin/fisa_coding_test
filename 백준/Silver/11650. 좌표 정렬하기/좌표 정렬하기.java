import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Coordinate> c = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            c.offer(new Coordinate(sc.nextInt(), sc.nextInt()));
        }

        while (!c.isEmpty()){
            Coordinate poll = c.poll();
            System.out.println(poll.x + " " + poll.y);
        }
    }

    public static class Coordinate implements Comparable<Coordinate> {
        int x, y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}