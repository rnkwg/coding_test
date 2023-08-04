package com.example.coding.baekjoon.step1;

import java.io.*;

public class b_18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        Long year = Long.parseLong(br.readLine());
        bw.write((year - 543) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
