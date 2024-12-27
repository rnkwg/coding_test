package com.example.coding.programmers.lv2;
import java.util.*;
public class 영어끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            // 탈락 규칙 1: 끝말잇기 실패
            // 탈락 규칙 2: 이전에 등장했던 단어 재등장

            int person = 0; // 탈락하는 사람
            int turn = 0;   // 탈락하는 차례
            Map<String, Integer> map = new HashMap<>(); // 끝말잇기 단어 저장

            // 첫번째 단어 저장
            map.put(words[0], 1);

            for(int i = 1; i < words.length; i++) {
                if(words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)) {
                    // 끝말잇기에는 성공
                    if(!map.containsKey(words[i])) {
                        // 이전과 중복되지 않는 단어이면
                        // 단어 저장
                        map.put(words[i], 1);
                    } else {
                        // 중복되는 단어라면 탈락
                        // System.out.println("중복탈락:" + i + " " + words[i]);
                        person = (i + 1) % n;
                        if(person == 0) person = n;
                        // System.out.println("중복탈락:" + i + " " + person);
                        turn = i / n + 1;
                        break;
                    }
                } else {
                    // 끝말잇기 실패로 탈락
                    // System.out.println("실패탈락:" + i + " " + words[i + 1]);
                    person = (i + 1) % n;
                    if(person == 0) person = n;
                    turn = i / n + 1;
                    break;
                }
            }

            int[] answer = {person, turn};
            return answer;
        }
    }
}
