package com.example.coding.baekjoon.step1;

import java.io.*;

public class b_10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String str = br.readLine();
        bw.write(str + "??!\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
