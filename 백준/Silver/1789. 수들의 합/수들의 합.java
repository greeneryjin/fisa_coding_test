import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        //빼줄 값
        long N = 1;
        while(true) {
            if(n >= N) n -= N;
                //S보다 N이 작다면 반복을 종료해준다.
            else break;
            N++;
        }
        //--N을 해주는 이유는 N와 --는 순서상에 문제가 생기기에 N--를 하면 N을 출력하고 --를 한다.
        //그렇기에 빼주고 출력하기 위해 --를 앞에 두자.
        System.out.println(--N);
    }
}