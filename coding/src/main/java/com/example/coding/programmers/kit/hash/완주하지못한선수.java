package com.example.coding.programmers.kit.hash;
import java.util.*;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.put(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }

        // System.out.println(map);

        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])) {
                map.replace(completion[i], map.get(completion[i]) - 1);
            }
        }

        // System.out.println(map);

        for(String i : map.keySet()) { //저장된 key값 확인
            if(map.get(i) != 0) {
                answer += i;
            }
        }

        return answer;
    }
}
