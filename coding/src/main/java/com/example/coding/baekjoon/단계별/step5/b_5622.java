package com.example.coding.baekjoon.단계별.step5;

import java.io.*;

public class b_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String s = br.readLine();

        bw.write(s.length() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
