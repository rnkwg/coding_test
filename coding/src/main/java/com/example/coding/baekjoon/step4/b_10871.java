package com.example.coding.baekjoon.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1);

        int n = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());

        int num[] = new int[n];
        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2);
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        String result = "";
        for(int i = 0; i < n; i++) {
           if(num[i] < x)
               result += num[i] + " ";
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
