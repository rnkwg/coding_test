package com.example.coding.baekjoon.단계별.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(String.valueOf(br.readLine()));
        Double max = 0.0;
        Double arr[] = new Double[n];

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2);

        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st2.nextToken());
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        double sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i] / max * 100;
        }
        bw.write((sum / n) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
