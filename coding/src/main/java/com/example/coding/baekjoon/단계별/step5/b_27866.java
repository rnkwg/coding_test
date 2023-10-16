package com.example.coding.baekjoon.단계별.step5;

import java.io.*;
import java.util.StringTokenizer;

public class b_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        bw.write(s.charAt(i - 1) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
