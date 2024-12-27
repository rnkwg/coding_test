package com.example.coding.programmers.lv2;

public class 피보나치수 {
    class Solution {
        public Long solution(int n) {
            long[] fibo = new long[n + 1];

            fibo[0] = 0;
            fibo[1] = 1;
            for(int i = 2; i < n + 1; i++) {
                fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
            }

            long answer = fibo[n];
            return answer;
        }
    }
}
