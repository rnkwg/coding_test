package com.example.coding.baekjoon.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(String.valueOf(br.readLine()));
        int max = 0;
        int arr[] = new int[n];

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2);

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        double sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i] / max * 100;
        }
        bw.write((sum / n) + "\n");

//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        Long A = Long.parseLong(st.nextToken());
//        Long B = Long.parseLong(st.nextToken());
//
//        if(A > B)
//            bw.write(">\n");
//        else if(A < B)
//            bw.write("<\n");
//        else
//            bw.write("==\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
