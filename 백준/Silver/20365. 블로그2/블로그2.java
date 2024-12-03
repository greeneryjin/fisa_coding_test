import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();

        int red = 0;
        int blue = 0;
        char currentWord = 'N';

        String s = scan.next();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                if(s.charAt(i) == currentWord) {
                    continue;
                } else {
                    red++;
                    currentWord = 'R';
                }
            } else {
                if(s.charAt(i) == currentWord) {
                    continue;
                } else {
                    blue++;
                    currentWord = 'B';
                }
            }
        }
        System.out.println(Math.min(red, blue) + 1);
    }
}