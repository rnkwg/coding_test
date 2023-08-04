package com.example.coding.baekjoon.step1;

import java.io.*;
import java.util.StringTokenizer;

public class b_10998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Double A = Double.parseDouble(st.nextToken());
        Double B = Double.parseDouble(st.nextToken());

        bw.write(A * B + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
