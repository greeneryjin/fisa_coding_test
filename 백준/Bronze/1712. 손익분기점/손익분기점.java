import java.util.*;
import java.io.*;

/*
 * 16236번 아기상어
 * 상어가 이동할 때마다 방문 처리를 함
 * 상어가 물고기를 먹을 때마다 배열에 저장하고 배열 내부 값과 아기 상어 크기와 비교후 같으면 증가
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;

        //기존 코드
//        int i = 1;
//        while(i != 2100000000) {
//            if(c * i > a + (b * i)){
//                System.out.println(answer);
//                break;
//            }
//            answer = i;
//            i++;
//        }
//        answer = -1;
//        System.out.println(answer);

        /*
         * c * N > a + (b * N) -> 손익분기를 계산하는 공식
         * 고정 값을 전부 한 곳으로 몰아서 계산해야함.
         * c * N - (b * N) > a
         * N ( c - b ) > a
         * N > a / (c - b)
         * c - b < 0으로 c < b가 되면 이 식은 성립되지 않는다.
         * */
        //수정된 코드
        if(c <= b) {
            System.out.println(-1);
        } else {
            System.out.println(a/(c-b) + 1);
        }


    }
}
