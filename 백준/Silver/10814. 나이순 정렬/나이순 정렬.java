import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<People> p = new PriorityQueue<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int age = Integer.parseInt(sc.next());
            String name = sc.nextLine();
            p.offer(new People(i, age, name));
        }

        while(!p.isEmpty()) {
            System.out.println(p.poll());
        }
    }

    static class People implements Comparable<People> {
        int num, age;
        String name;
        public People(int num, int age, String name){
            this.num = num;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(People o) {
            if(this.age > o.age){
                return 1;
            } else if (this.age < o.age) {
                return -1;
            } else {
                //참 : 거짓 = -1, 1
                return this.num < o.num ? -1 : 1;
            }
        }

        @Override
        public String toString() {
            return age + "" + name;
        }
    }
}