import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int data = Integer.valueOf(st.nextToken());
            map.put(data, 0);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int data = Integer.valueOf(st.nextToken());
            if(map.get(data) != null) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

            /**
         * 1. 먼저 해시함수에 저장을 해야함 -> 배열에 먼저 저장하고 해시함수를 찾을 경우, 값의 순서를 보장하지 못함
         * 2. 조회가 너무 많이 일어나는 경우가 발생 -> 배열 저장, 해시 저장, 배열 조회, 해시 조회 -> 순서 맞지 않음
         *
         * */
//        int[] arr = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++) {
//            int data = Integer.valueOf(st.nextToken());
//            arr[i] = data;
//        }
//        Arrays.sort(arr);
//
//        st = new StringTokenizer(br.readLine());
//        int m = Integer.valueOf(st.nextToken());
//        int[] ans = new int[m];
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++) {
//            int data = Integer.valueOf(st.nextToken());
//            map.put(data, 0);
//        }
//
//        List<Integer> keySet = new ArrayList<>(map.keySet());
//        Collections.sort(keySet);
//        for(int i = 0; i < arr.length; i++) {
//            if(keySet.contains(arr[i])) {
//                ans[i] = 1;
//            } else {
//                ans[i] = 0;
//            }
//        }
//
//        for(int i = 0; i < ans.length; i++) {
//            System.out.println(ans[i]);
//        }
}
