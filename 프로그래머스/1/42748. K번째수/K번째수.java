import java.util.*;

class Solution {
    public int[] solution(int[] a, int[][] c) {
        int[] answer = new int[c.length];
        for(int i = 0; i < c.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int j = c[i][0] - 1; j < c[i][1]; j++) {
                arr.add(a[j]);         
            }
            Collections.sort(arr);
            answer[i] = arr.get(c[i][2] - 1);   
        }
        return answer;
    }
}