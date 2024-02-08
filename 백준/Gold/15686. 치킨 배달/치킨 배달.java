import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //거리 배열
    static int[][] arr;

    //배열의 크기
    static int n;

    //치킨집 개수 정함
    static int m;

    //방문 처리 크기
    static int len = 0;

    //전체 치킨 리스트
    static ArrayList<Chicken> chicken = new ArrayList<>();

    //전체 집 리스트
    static ArrayList<Chicken> home = new ArrayList<>();

    //조합으로 만들어진 치킨 리스트
    static ArrayList<ArrayList<Chicken>> chickenCon = new ArrayList<>();

    //거리의 최소값
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int data = sc.nextInt();
                if(data == 2) {
                    len++;
                    chicken.add(new Chicken(i, j));
                }

                if(data == 1) {
                    home.add(new Chicken(i, j));
                }
                arr[i][j] = data;
            }
        }
        combination();
        System.out.println(min);
    }

    //조합을 만들기 위한 함수
    private static void combination() {

        //치킨 가게의 조합을 구할 임시 리스트
        ArrayList<Chicken> curr = new ArrayList<>();

        //임시 조합을 만들 방문 배열
        boolean[] currVisit = new boolean[len];

        int start = 0;

        backtrack(curr, currVisit, start, 0);

        //선택한 치킨가게와 집의 거리 구하기
        findDistance();
    }

    //조합에서 선택된 치킨집과 집의 거리를 구한 후, 가장 작은 최솟값을 찾기
    private static void findDistance() {

        for (int i = 0; i < chickenCon.size(); i++) {
            ArrayList<Chicken> chickens = chickenCon.get(i);
            int distance = distance(chickens, m);
            min = Math.min(min, distance);
        }
    }

    public static int distance(ArrayList<Chicken> arr, int m){

        int[] com = new int[home.size()];
        for (int i = 0; i < m; i++) {
            Chicken chicken1 = arr.get(i);

            for (int j = 0; j < home.size(); j++) {
                Chicken disHome = home.get(j);
                int result = Math.abs(disHome.x - chicken1.x) + Math.abs(disHome.y - chicken1.y);
                if(i == 0) {
                    com[j] = result;
                }
                else {
                    com[j] = Math.min(com[j], result);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < com.length; i++) {
            result += com[i];
        }
        return result;
    }

    //전체 치킨 가게에서 m를 선택하는 함수
    public static void backtrack(ArrayList<Chicken> curr, boolean[] currVisit, int start, int count) {
        if(count == m){
            chickenCon.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < currVisit.length; i++) {
            if(!currVisit[i]) {
                currVisit[i] = true;
                curr.add(chicken.get(i));
                backtrack(curr, currVisit, i+1, count+1);
                currVisit[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static class Chicken {
        int x;
        int y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}