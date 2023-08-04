package com.example.coding.baekjoon.step3;

import java.io.*;
import java.util.StringTokenizer;

public class b_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int sum[] = new int[T];
        int num1[] = new int[T];
        int num2[] = new int[T];

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");

            num1[i] = Integer.parseInt(st.nextToken());
            num2[i] = Integer.parseInt(st.nextToken());
            sum[i] = num1[i] + num2[i];
        }

        for(int i = 0; i < T; i++) {
            bw.write("Case #" + (i + 1) + ": " +
                    num1[i] + " + " + num2[i] + " = " + sum[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
