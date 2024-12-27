package com.example.coding.programmers.lv2;
import java.util.*;
public class 귤고르기 {
    class Solution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> map = new HashMap<>(); // (귤의 크기, 귤의 갯수) 귤의 크기에 해당하는 갯수
            for(int i = 0; i < tangerine.length; i++) {
                if(map.containsKey(tangerine[i])) {
                    // 이미 map에 포함되어 있다면 기존의 갯수 + 1
                    map.put(tangerine[i], map.get(tangerine[i]) + 1);
                } else {
                    // 포함되어 있지 않다면 개수=1
                    map.put(tangerine[i], 1);
                }
            }

            // 귤 갯수를 list 로 변환
            List<Integer> counts = new ArrayList<>(map.values());

            // 귤 갯수 기준으로 내림차순 정렬
            counts.sort(Collections.reverseOrder());

            int total = 0;
            int type = 0;

            for(int i = 0; i < counts.size(); i++) {
                // System.out.println(counts.get(i));
                total += counts.get(i);
                type += 1;
                if(total >= k) {
                    break;
                }
            }

            return type;
        }
    }
}
