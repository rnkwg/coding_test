package com.example.coding.baekjoon.step4;

import java.io.*;

public class b_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num[] = new int[10];
        int count[] = new int[42];
        int check = 0;

        for(int i = 0; i < 42; i++) {
            count[i] = 0;
        }

        for(int i = 0; i < 10; i++) {
            num[i] = Integer.parseInt(br.readLine());
            num[i] = num[i] % 42;
            count[num[i]]++;
        }

        for(int i = 0; i < 42; i++) {
            if(count[i] > 0) {
                check++;
            }
        }

        bw.write(check + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
