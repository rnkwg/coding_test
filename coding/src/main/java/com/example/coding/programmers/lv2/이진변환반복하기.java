package com.example.coding.programmers.lv2;
import java.util.*;
public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;  // 이진 변환의 횟수
        int zero = 0;   // 변환 과정에서 제거된 0의 갯수

        while(!s.equals("1")) {
            // s가 1이 될 때까지
            int one = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {    // 0인 경우 zero + 1
                    zero += 1;
                } else {    // s의 1의 갯수를 구한다
                    one += 1;
                }
            }

            // s의 1의 갯수를 2진법으로 바꾸기
            s = binary(one);

            // 이진 변환의 횟수 증가
            count += 1;
        }

        answer[0] = count;
        answer[1] = zero;

        return answer;
    }

    // 2진법으로 만든다
    public String binary(int one) {
        Stack<String> stack = new Stack<>();
        String binaryNumber = "";

        while(one != 0) {
            stack.push(String.valueOf(one % 2));
            one /= 2;
        }

        while(!stack.isEmpty()) {
            binaryNumber += stack.pop();
        }

        return binaryNumber;
    }
}
