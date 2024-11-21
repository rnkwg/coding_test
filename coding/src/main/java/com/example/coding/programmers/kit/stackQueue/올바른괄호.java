package com.example.coding.programmers.kit.stackQueue;
import java.util.*;

public class 올바른괄호 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));    //스택에 첫번째 괄호를 넣는다

            for(int i = 1; i < s.length(); i++) {
                if(stack.isEmpty()) {   // 스택이 비어 있으면 괄호를 스택에 넣는다
                    stack.push(s.charAt(i));
                } else {
                    if(stack.peek() == '(' && s.charAt(i) == ')') // 괄호 조건을 만족하면
                        stack.pop();    // 스택에서 꺼낸다
                    else {  // 괄호 조건 미충족이면 괄호를 스택에 넣는다
                        stack.push(s.charAt(i));
                    }
                }
            }

            if(!stack.isEmpty()) {
                answer = false;
            }

            return answer;
        }
    }
}
