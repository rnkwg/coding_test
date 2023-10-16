package com.example.coding.baekjoon.단계별.step2;

import java.io.*;
import java.util.StringTokenizer;
public class b_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int score = Integer.parseInt(st.nextToken());

        if(score >= 90 && score <= 100)
            bw.write("A\n");
        else if(score >= 80 && score <= 89)
            bw.write("B\n");
        else if(score >= 70 && score <= 79)
            bw.write("C\n");
        else if(score >= 60 && score <= 69)
            bw.write("D\n");
        else
            bw.write("F\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
