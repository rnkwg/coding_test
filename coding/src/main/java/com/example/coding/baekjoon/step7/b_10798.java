package com.example.coding.baekjoon.step7;

import java.io.*;
import java.util.StringTokenizer;

public class b_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        char[][] chars = new char[5][15];

        //입력값 받기
        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++)
                chars[i][j] = s.charAt(j);
        }

        /**
         * (0,0) (1,0) .. (5,0)
         * (0,1) (1,1) .. (5,1)
         * ..
         * (0,15) (1,15) .. (5,15)
         */
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(chars[j][i] == ' ' || chars[j][i] == '\0')
                    continue;
                bw.write(chars[j][i] + "");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
