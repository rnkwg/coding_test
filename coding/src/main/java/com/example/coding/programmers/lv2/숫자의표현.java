package com.example.coding.programmers.lv2;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        // 이분탐색처럼 투포인터 이용
        int start = 1;
        int end = 1;
        int sum = 1;

        while(end < n) {
            if(sum == n) {
                // sum 이 n과 같은 경우
                answer += 1;
                end += 1;
                sum += end;
            } else if(sum < n) {
                // sum 이 n보다 작은 경우
                // end 값 증가 필요
                end += 1;
                sum += end;
                // System.out.println("case 1 start: " + start + " end: " + end + " sum: " + sum);
            } else {
                // sum 이 n보다 큰 경우
                // start 값 증가 필요
                sum -= start;
                start += 1;
                // sum += start;
                // System.out.println("case 2 start: " + start + " end: " + end + " sum: " + sum);
            }
        }

        return answer + 1;
    }
}
