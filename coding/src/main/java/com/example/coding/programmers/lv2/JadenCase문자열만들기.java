package com.example.coding.programmers.lv2;
import java.util.*;
public class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";

        // 공백을 기준으로 나누어줌
        String[] array = s.split(" ");
        for(int i = 0; i < array.length; i++) {
            String token = array[i];

            System.out.println("token: "+ token);

            // 만약 공백이 있는 경우에는 공백 더해주기
            if(token.length() == 0) {
                answer += " ";
            } else if(i != array.length - 1) {
                // 마지막 단어가 아닌 경우
                // 뒤에 띄어쓰기 위한 공백을 더해줌
                answer += String.valueOf(token.charAt(0)).toUpperCase()
                        + token.substring(1, token.length()).toLowerCase() + " ";
            } else {
                // 마지막 단어인 경우 공백을 더해주지 않는다
                answer += String.valueOf(token.charAt(0)).toUpperCase()
                        + token.substring(1, token.length()).toLowerCase();
            }
        }

        // 문자열의 마지막에 공백이 존재하는 경우 공백을 더해준다
        if(s.endsWith(" "))
            answer += " ";

        return answer;
    }
}
