class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i = 0; i <= t.length() - p.length(); i++) {
            long x = Long.parseLong(t.substring(i, i + p.length()));
            long y = Long.parseLong(p);
            if(y >= x){
                answer++;
            }
        }
        return answer;
    }
}