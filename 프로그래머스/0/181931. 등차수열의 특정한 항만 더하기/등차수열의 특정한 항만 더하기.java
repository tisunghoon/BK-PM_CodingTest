class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for (int i=0; i < included.length; i++){
            // 등차수열 항 만들기 a+(i*d)
            int currentTerm = a + (i*d);
            if (included[i]){
                answer += currentTerm;
            }
        }
        
        return answer;
    }
}