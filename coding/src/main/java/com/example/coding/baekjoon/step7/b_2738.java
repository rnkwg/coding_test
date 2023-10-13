package com.example.coding.baekjoon.step7;

import java.io.*;
import java.util.StringTokenizer;

public class b_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int[][] A = new int[9][9];
        int max = -1;
        int h = 0, y = 0;

        //입력값 받기
        for(int i = 0; i < 9; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++) {
                A[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        //최댓값 계산
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(max < A[i][j]) {
                    max = A[i][j];
                    h = i;
                    y = j;
                }
            }
        }

        bw.write(max + "\n" + (h + 1) + " " + (y + 1));
        bw.flush();
        bw.close();
        br.close();
    }
}
