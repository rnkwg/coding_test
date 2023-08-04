package com.example.coding.baekjoon.step3;

import java.io.*;

public class b_8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
