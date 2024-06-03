class Solution {
    public String solution(String n) {
        String answer = "";
        int count = n.length() - 4;
        
        String tmp = n.substring(count, n.length());
        for(int i = 0; i < count; i++) {
            answer += "*";
        }
        
        return answer + tmp;
    }
}