package com.example.coding.baekjoon.step1;

import java.io.*;
import java.util.StringTokenizer;

public class b_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long C = Long.parseLong(st.nextToken());

        bw.write(A + B + C + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
