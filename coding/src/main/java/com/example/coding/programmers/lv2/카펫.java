package com.example.coding.programmers.lv2;
import java.util.*;
public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int weight;
            int height;

            // weight * height = yellow
            // 2 * weight + 2 * hegith - 4 = brown

            int temp = -1;
            for(int i = 1; i <= yellow; i++) {
                if(yellow % i == 0) {
                    temp = yellow / i;
                    if(i * 2 + temp * 2 + 4 == brown) {
                        break;
                    }
                }
            }

            System.out.println("temp: " + temp);

            int[] answer = new int[2];

            answer[0] = temp + 2;
            answer[1] = (yellow + brown) / answer[0];

            return answer;
        }
    }
}
