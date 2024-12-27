package com.example.coding.programmers.lv2;

public class 멀리뛰기 {
    class Solution {
        public long solution(int n) {
            long[] dp = new long[2001];

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            // i칸으로 이동가능한 경우의 수
            // = i-2칸으로 이동할 수 있는 경우의 수 + i-1칸으로 이동할 수 있는 경우의 수
            for(int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
            }

            return dp[n];
        }
    }
}
