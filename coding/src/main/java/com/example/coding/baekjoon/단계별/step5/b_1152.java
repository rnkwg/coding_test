package com.example.coding.baekjoon.단계별.step5;

import java.io.*;
import java.util.StringTokenizer;

public class b_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String st = br.readLine();
        StringTokenizer str = new StringTokenizer(st);

        bw.write(str.countTokens() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
