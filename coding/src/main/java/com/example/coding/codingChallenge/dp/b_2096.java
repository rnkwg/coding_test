package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.StringTokenizer;

public class b_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[][] game = new int[n][3];
        int[][] dMin = new int[n][3];
        int[][] dMax = new int[n][3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 3; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp max
        dMax[0][0] = game[0][0];
        dMax[0][1] = game[0][1];
        dMax[0][2] = game[0][2];

        for(int i = 1; i < n; i++) {
            dMax[i][0] = Math.max(dMax[i - 1][0], dMax[i - 1][1]) + game[i][0];
            dMax[i][1] = Math.max(dMax[i - 1][0], Math.max(dMax[i - 1][1], dMax[i - 1][2])) + game[i][1];
            dMax[i][2] = Math.max(dMax[i - 1][1], dMax[i - 1][2]) + game[i][2];
        }

        // dp min
        dMin[0][0] = game[0][0];
        dMin[0][1] = game[0][1];
        dMin[0][2] = game[0][2];

        for(int i = 1; i < n; i++) {
            dMin[i][0] = Math.min(dMin[i - 1][0], dMin[i - 1][1]) + game[i][0];
            dMin[i][1] = Math.min(dMin[i - 1][0], Math.min(dMin[i - 1][1], dMin[i - 1][2])) + game[i][1];
            dMin[i][2] = Math.min(dMin[i - 1][1], dMin[i - 1][2]) + game[i][2];
        }

        bw.write(Math.max(dMax[n - 1][0], Math.max(dMax[n - 1][1], dMax[n - 1][2])) + " ");
        bw.write(Math.min(dMin[n - 1][0], Math.min(dMin[n - 1][1], dMin[n - 1][2])) + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
