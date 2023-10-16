package com.example.coding.baekjoon.step7;

import java.io.*;
import java.util.StringTokenizer;

public class b_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int[][] graph = new int[100][100];

        /**
         * 입력
         * 3
         * 3 7
         * 15 7
         * 5 2
         *
         * 출력
         * 260
         *
         */

        //배열 초기화
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++)
                graph[i][j] = 0;
        }

        //입력값 받고 + 1씩 더하기
        int n = Integer.parseInt(br.readLine());
        int width = n * 100;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j = a; j < a + 10; j++) {
                for(int k = b; k < b + 10; k++)
                    graph[j][k] += 1;
            }
        }

        //배열 초기화
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++)
                if(graph[i][j] > 1)
                    width -= graph[i][j] - 1;
        }

        bw.write(width + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
