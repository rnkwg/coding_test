package com.example.coding.codingChallenge.dp;

import java.io.*;

public class b_2156 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        int[] d = new int[n];
        for(int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        // dp
        d[0] = wine[0];
        if(n >= 2)
            d[1] = wine[0] + wine[1];
        if(n >= 3)
            d[2] = Math.max(Math.max(d[1], wine[0] + wine[2]), wine[1] + wine[2]);
        if(n >= 4) {
            for (int i = 3; i < n; i++) {
                d[i] = Math.max(Math.max(d[i - 1], d[i - 2] + wine[i]), d[i - 3] + wine[i - 1] + wine[i]);
            }
        }

        bw.write(d[n - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
