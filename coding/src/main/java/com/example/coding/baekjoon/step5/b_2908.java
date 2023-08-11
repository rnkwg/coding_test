package com.example.coding.baekjoon.step5;

import java.io.*;
import java.util.StringTokenizer;

public class b_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        bw.write((A > B ? A : B) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
