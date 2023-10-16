package com.example.coding.baekjoon.단계별.step1;

import java.io.*;


public class b_10171 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        bw.write("\\    /\\\n" +
                " )  ( ')\n" +
                "(  /  )\n" +
                " \\(__)|");

        bw.flush();
        bw.close();
    }
}
