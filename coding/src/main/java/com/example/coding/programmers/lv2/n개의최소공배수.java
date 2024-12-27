package com.example.coding.programmers.lv2;

public class n개의최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            // 최소공배수 담을 dp 배열
            int[] lcm = new int[arr.length];
            lcm[0] = arr[0];
            for(int i = 1; i < arr.length; i++) {
                lcm[i] = getLcm(lcm[i - 1], arr[i]);
            }

            return lcm[lcm.length - 1];
        }
        // 6과 8의 최소공배수 구하기
        // 6과 8의 최대공약수는 2
        // 2 * (6 / 2) * (8 / 2) = 24
        // a와 b의 최소공배수를 구하는 함수
        public int getLcm(int a, int b) {
            int max = -1;   // 최대공약수

            for(int i = 1; i <= a; i++) {
                if(a % i == 0 && b % i == 0) {
                    // a와 b의 최대공약수를 찾는다
                    if(max < i) {
                        max = i;
                    }
                }
            }
            return max * (a / max) * (b / max);
        }
    }
}
