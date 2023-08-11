package com.example.coding.baekjoon.step6;

import java.io.*;

public class b_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = n - i; j >= 0; j--)
                bw.write(" ");
            for(int k = 1; k <= i * 2 - 1; k++)
                bw.write("*");
            bw.write("\n");
        }

        for(int i = 1; i <= n - 1; i++) {
            for(int j = 1; j <= i + 1; j++)
                bw.write(" ");
            for(int k = i; k <= i + n; k++)
                bw.write("*");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
