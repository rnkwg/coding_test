package com.example.coding.programmers.kit.hash;
import java.util.*;
public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 이중 for 문을 통해 해결, 효율성 테스트 실패
//         Arrays.sort(phone_book);

//         for(int i = 0; i < phone_book.length; i++) {
//             for(int j = 0; j < i; j++) {
//                 if(phone_book[i].startsWith(phone_book[j])) {
//                     answer = false;
//                     break;
//                 }
//             }
//         }

        HashMap<String, String> map = new HashMap<>();
        // map에 모든 phone_book 의 값을 다 넣는다
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i]);
        }

        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
