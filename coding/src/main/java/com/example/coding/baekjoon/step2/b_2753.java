package com.example.coding.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class b_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int year = Integer.parseInt(st.nextToken());

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            bw.write("1\n");
        else
            bw.write("0\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
