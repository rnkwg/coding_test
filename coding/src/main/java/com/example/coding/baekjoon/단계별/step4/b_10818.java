package com.example.coding.baekjoon.단계별.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int num[] = new int[n];

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2);
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        int max = num[0];
        int min = num[0];
        for(int i = 0; i < n; i++) {
            if(num[i] < min)
                min = num[i];
            if(num[i] > max)
                max = num[i];
        }
        bw.write(min + " " + max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
