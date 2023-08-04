package com.example.coding.baekjoon.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


//        String str1 = br.readLine();
//        StringTokenizer st1 = new StringTokenizer(str1);

        int n = Integer.parseInt(br.readLine());
//        int x = Integer.parseInt(st1.nextToken());

        int num[] = new int[n];

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2);
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

//        String result = "";
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
