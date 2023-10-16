package com.example.coding.baekjoon.단계별.step5;

import java.io.*;

public class b_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String arr[] = s.split("");

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(arr[i]);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
