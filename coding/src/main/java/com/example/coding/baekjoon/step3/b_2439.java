package com.example.coding.baekjoon.step3;

import java.io.*;

public class b_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = n - i - 1; j >= 0; j--)
                bw.write(" ");
            for(int k = 1; k <= i; k++)
                bw.write("*");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
