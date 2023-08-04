package com.example.coding.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class b_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        if(A > B)
            bw.write(">\n");
        else if(A < B)
            bw.write("<\n");
        else
            bw.write("==\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
