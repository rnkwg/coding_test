package com.example.coding.programmers.lv2;
import java.util.*;

public class 다음큰숫자 {

    class Solution {
        public int solution(int n) {
            // 입력받은 수 이진수로 변환
            String binary = Integer.toBinaryString(n);

            // 1의 갯수세기
            binary = binary.replace("0", "");
            int temp = n + 1;

            while(true) {
                String tempBinary = Integer.toBinaryString(temp);
                tempBinary = tempBinary.replace("0", "");

                if(tempBinary.length() == binary.length())
                    break;
                else
                    temp += 1;
            }

            return temp;
        }

        // 2진법으로 만든다
        // 만든 2진법에서 1의 갯수를 반환한다
        public int binary(int one) {
            Stack<String> stack = new Stack<>();
            int oneCount = 0;

            while(one != 0) {
                stack.push(String.valueOf(one % 2));
                one /= 2;
            }

            while(!stack.isEmpty()) {
                if(stack.pop().equals("1")) {
                    oneCount += 1;
                }
            }

            return oneCount;
        }

    }
}
