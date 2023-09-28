import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        //참가자의 이름과 숫자 저장
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0)+1);
        }  
        for(String comp : completion) {
            map.put(comp, map.get(comp)-1);
        }
        for(String part : participant){
            if(map.get(part) > 0) {
                answer = part;
                break;
            }
        }
        return answer;
    }
}