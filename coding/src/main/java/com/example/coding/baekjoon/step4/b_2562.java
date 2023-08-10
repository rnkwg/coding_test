package com.example.coding.baekjoon.step4;

import java.io.*;

public class b_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num[] = new int[9];
        int max = -1;
        int check = 0;

        for(int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if(max < num[i]) {
                max = num[i];
                check = i;
            }
        }

        bw.write(max + "\n" + (check + 1) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
