package com.example.coding.programmers.kit.stackQueue;
import java.util.*;
public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(arr[0]);
        for(int i = 0; i < arr.length; i++) {
            // System.out.println("stack.peek()" + stack.peek() + " arr[i]" + arr[i]);
            if(stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        answer = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            // System.out.println("stack.pop()" + stack.pop());
            answer[i] = stack.pop();
        }

        return answer;
    }
}
