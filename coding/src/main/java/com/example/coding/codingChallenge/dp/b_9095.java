package com.example.coding.codingChallenge.dp;

import java.io.*;

public class b_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[12];
        int[] D = new int[12];
        for(int i = 1; i <= n; i++)
            array[i] = Integer.parseInt(br.readLine());

        // dp
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for(int i = 4; i < 12; i++) {
            D[i] = D[i - 3] + D[i - 2] + D[i - 1];
        }

        for(int i = 1; i <= n; i++) {
            bw.write(D[array[i]] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
