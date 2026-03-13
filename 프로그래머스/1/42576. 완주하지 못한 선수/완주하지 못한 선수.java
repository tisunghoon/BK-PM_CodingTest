import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player : participant){
            map.put(player, map.getOrDefault(player, 0)+1);
        }   
        for (String player : completion){
            map.put(player, map.get(player)-1);
        }
        for (String key : map.keySet()){
            if(map.get(key) !=0){
                answer = key;
                break;
            }
        }
            
        /*
        1. 문제 파악
        2. 어떻게 풀어야 될지 흐름 정하기
        3. 내가 사용할 수 있는 문법 체크
        4. 이를 활용해서 코드 적기
        */
        
        return answer;
    }
}