package com.example.coding.programmers.lv2;
import java.util.*;
public class 짝지어제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            int answer = 0;
            Stack<Character> stack = new Stack<>();

            // 스택에 첫번째 문자 삽입
            stack.push(s.charAt(0));

            for(int i = 1; i < s.length(); i++) {
                // 스택이 비어 있다면
                // 스택에 문자 삽입
                if(stack.isEmpty()) {
                    stack.push(s.charAt(i));
                } else {
                    // 스택의 맨 위에 있는 문자열과 다음 문자열이 동일하다면
                    // s에서 제거 대상
                    if(stack.peek() == s.charAt(i)) {
                        stack.pop();
                    } else {
                        // 동일하지 않다면 해당 문자열도 스택에 삽입
                        stack.push(s.charAt(i));
                    }
                }
                // System.out.println(i + "번째 : " + s.charAt(i));
            }

            // while(!stack.isEmpty()) {
            //     System.out.println(stack.pop());
            // }

            if(stack.isEmpty()) {
                answer = 1;
            }

            return answer;
        }
    }
}
