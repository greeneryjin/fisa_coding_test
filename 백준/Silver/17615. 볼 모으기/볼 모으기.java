import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int red = 0;
        int blue = 0;
        int min = Integer.MAX_VALUE;

        String s = scan.next();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                red++;
            } else {
                blue++;
            }
        }

        //red 왼쪽
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        count = red - count;
        min = Math.min(min, count);

        //red 오른쪽
        count = 0;
        for (int i = n - 1; i > 0; i--) {
            if(s.charAt(i) == 'R') {
                count++;
            } else {
                break;
            }
        }
        count = red - count;
        min = Math.min(min, count);

        //blue 왼쪽
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        count = blue - count;
        min = Math.min(min, count);

        //blue 오른쪽
        count = 0;
        for (int i = n - 1; i > 0; i--) {
            if(s.charAt(i) == 'B') {
                count++;
            } else {
                break;
            }
        }
        count = blue - count;
        min = Math.min(min, count);

        System.out.println(min);
    }
}