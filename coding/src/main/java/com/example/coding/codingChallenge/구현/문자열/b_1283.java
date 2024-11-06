package com.example.coding.codingChallenge.구현.문자열;

import java.io.*;
import java.util.*;

public class b_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 각 옵션별로 단축키 저장
        // 중복을 불허하므로 set 이용
        Set<Object> set = new HashSet<>();

        // 출력문 만들기
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean flag = false;   // 단축키 찾음 유무

            // 1번 규칙
            // 각 단축키의 첫번째 단어의 첫번째 알파벳이 map에 없는 경우
            // set에 대문자로 바꾸어서 넣어줌
            for(int j = 0; j < words.length; j++) {
                // 각 단어의 첫번째 글자를 대상으로 map 에 있는지 여부 확인
                if(!flag && !set.contains(Character.toUpperCase(words[j].charAt(0)))) {
                    set.add(Character.toUpperCase(words[j].charAt(0)));
                    // 출력문 만들기
                    sb.append("[" + words[j].charAt(0) + "]" + words[j].substring(1) + " ");
                    flag = true;
                } else {
                    // 없으면 그래도 출력은 해야하니 해당 단어를 출력문에 넣어주기
                    sb.append(words[j] + " ");
                }
            }

            // 2번 규칙
            // 각 단어의 첫글자가 단축키 지정 안된 경우
            // 각 단어의 순서대로 나머지 글자들 확인하기
            if(!flag) {
                // 버퍼 초기화
                sb.setLength(0);
                // 각 단어 탐색
                for(int j = 0; j < words.length; j++) {
                    if(!flag) {
                        // 단어의 글자들 탐색
                        for(int k = 0; k < words[j].length(); k++) {
                            if(!flag && !set.contains(Character.toUpperCase(words[j].charAt(k)))) {
                                set.add(Character.toUpperCase(words[j].charAt(k)));
                                // 출력문 만들기
                                sb.append(words[j].substring(0, k)
                                        + "[" + words[j].charAt(k) + "]"
                                        + words[j].substring(k + 1, words[j].length()) + " ");
                                flag = true;
                                break;
                            }
                        }
                        // 없으면 그래도 출력은 해야하니 해당 단어를 출력문에 넣어주기
                        if(!flag) {
                            sb.append(words[j] + " ");
                        }
                    } else {
                        // 없으면 그래도 출력은 해야하니 해당 단어를 출력문에 넣어주기
                        sb.append(words[j] + " ");
                    }
                }
            }

            // 3번 규칙
            // 단축키 설정 불가 시 그대로 출력
            if(!flag) {
                sb.setLength(0);
                sb.append(line);
            }

            bw.write(sb + "\n");
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
