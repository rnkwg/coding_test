package com.example.coding.baekjoon.step7;

import java.io.*;
import java.util.StringTokenizer;

public class b_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        int[][] C = new int[N][M];

        //입력값 받기
        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        //행렬 계산
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                C[i][j] = A[i][j] + B[i][j];
                bw.write(C[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
