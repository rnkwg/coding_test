package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.StringTokenizer;

public class b_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][4];
        int[][] d = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        d[0][0] = cost[0][0];
        d[0][1] = cost[0][1];
        d[0][2] = cost[0][2];

        for(int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i - 1][1], d[i - 1][0]) + cost[i][2];
        }

        bw.write(Math.min(d[n - 1][0], Math.min(d[n - 1][1], d[n - 1][2])) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
