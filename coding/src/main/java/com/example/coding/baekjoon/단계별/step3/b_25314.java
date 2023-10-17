package com.example.coding.baekjoon.단계별.step3;

import java.io.*;

public class b_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = n / 4;

        for(int i = 0; i < count; i++) {
            bw.write("long ");
        }
        bw.write("int ");

        bw.flush();
        bw.close();
        br.close();
    }
}
