package com.example.coding.baekjoon.단계별.step3;

import java.io.*;
import java.util.StringTokenizer;

public class b_10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int sum[] = new int[T];

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            sum[i] = num1 + num2;
        }

        for(int i = 0; i < T; i++) {
            bw.write(sum[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
