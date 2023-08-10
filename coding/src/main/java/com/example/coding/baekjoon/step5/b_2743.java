package com.example.coding.baekjoon.step5;

import java.io.*;

public class b_2743 {
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
