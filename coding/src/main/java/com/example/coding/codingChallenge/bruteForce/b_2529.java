package com.example.coding.codingChallenge.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class b_2529 {
    static String answer = "";
    static String temp = "";
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String[] bu = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < k; i++) {
            bu[i] = st.nextToken();
        }

        int[] descNum = new int[k + 1];    // 최대정수를 찾기 위한 배열
        int[] ascNum = new int[k + 1];     // 최소정수를 찾기 위한 배열
        for(int i = 0;  i < k + 1; i++) {
            descNum[i] =  9 - i;
            ascNum[i] = i;
        }

        dfs(descNum, new boolean[k + 1], bu, new int[k + 1], k, 0);
        answer += temp + "\n";
        temp = "";
        check = false;
        dfs(ascNum, new boolean[k + 1], bu, new int[k + 1], k, 0);
        answer += temp;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[] num, boolean[] visited, String[] bu, int[] arrayNum, int k, int depth) {
        // 종료 조건 : k + 1개의 숫자를 선택
        if(depth == k + 1) {
            // 부등호 관계 만족했는지 확인
            if(checkBu(bu, arrayNum)) {
                for(int i = 0; i < arrayNum.length; i++)
                    temp += String.valueOf(arrayNum[i]);
            }
            return;
        }

        for(int i = 0; i < num.length; i++) {
            if (!visited[i] && !check) {    // 최대정수와 최소정수를 구하기 위해서 check 검사
                visited[i] = true;
                arrayNum[depth] = num[i];
                dfs(num, visited, bu, arrayNum, k, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean checkBu(String[] bu, int[] arrayNum) {
        for(int i = 0; i < bu.length; i++) {
            if(bu[i].equals(">")) {
                if(arrayNum[i] < arrayNum[i + 1]) {
                    check = false;
                    break;
                }
            } else {
                if(arrayNum[i] > arrayNum[i + 1]) {
                    check = false;
                    break;
                }
            }
            check = true;   // 부등호 관계 만족
        }
        return check;
    }
}
