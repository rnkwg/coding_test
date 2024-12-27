package com.example.coding.programmers.lv2;

public class 점프와순간이동 {
    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while(n > 0) {
                if(n % 2 == 1) {
                    // n이 짝수이면
                    ans += 1;
                }
                n = n / 2;
            }
            return ans;
        }
    }
}
