package com.example.coding.programmers.lv2;
import java.util.*;
public class 구명보트 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            // 오름차순 정렬
            Arrays.sort(people);

            // 최대 2명이 보트 탑승 가능
            // 보트 갯수 최소화 하기 위해 가장 작은 몸무게 + 가장 큰 몸무게의 합과 limit 비교
            int start = 0;
            int end = people.length - 1;
            while(start <= end) {
                if(people[start] + people[end] <= limit) {
                    // answer += 1;
                    start += 1;
                    // System.out.println("start : " + start + " end: " + end);
                }

                // else if(people[start] + people[end] > limit) {
                end -= 1;
                answer += 1;
                // System.out.println("111start : " + start + " end: " + end);
                // }
            }

            return answer;
        }
    }
}
