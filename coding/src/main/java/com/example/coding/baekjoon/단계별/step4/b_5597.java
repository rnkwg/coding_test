package com.example.coding.baekjoon.단계별.step4;

import java.io.*;

public class b_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num[] = new int[30];
        int check = 0;
        String answer = "";

        for(int i = 0; i < 30; i++) {
            num[i] = 0;
        }

        for(int i = 0; i < 28; i++) {
            check = Integer.parseInt(br.readLine());
            num[check - 1] = 1;
        }

        for(int i = 0; i < 30; i++) {
            if(num[i] != 1) {
                answer += (i + 1) + "\n";
            }
        }

        bw.write(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
