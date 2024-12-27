package com.example.coding.programmers.lv2;

public class 예상대진표 {
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            // 다음 라운드에 진출 시 참가자의 번호가 1부터 n/2까지 다시 배정받음
            // (3, 4) 에서 이긴 번호는 2번으로 부여
            while(a != b) {
                // 두명이서 하는 게임이므로
                // 홀수번의 경우 나눈 후에 반올림이 필요하기 때문에 1을 먼저 더하고 나누어준다
                a = (a + 1) / 2;
                b = (b + 1) / 2;
                answer += 1;
            }

            return answer;
        }
    }
}
