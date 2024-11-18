package com.example.coding.programmers.lv2;

import java.util.StringTokenizer;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(s.trim());
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            System.out.println("num: " + num);

            if(num < min)
                min = num;
            if(num > max)
                max = num;
        }

        answer = min + " " + max;

        return answer;
    }
}
