package com.example.coding.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_11660_구간합_2차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        /**
         * 입력
         * 4 3
         * array
         * 1 2 3 4
         * 2 3 4 5
         * 3 4 5 6
         * 4 5 6 7
         *
         * sum
         * 1 3 6 10
         * 3 8 15 24
         * 6 15 27 42
         * 10 24 42 64
         *
         * 2 2 3 4
         * 3 4 3 4
         * 1 1 4 4
         *
         *
         * 출력
         * 27
         * 6
         * 64
         */

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][n];
        int[][] sum = new int[n][n];
        int[] answer = new int[m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        sum[0][0] = array[0][0];
//        sum[1][0] = array[1][0];
//        sum[0][1] = array[0][1];

        for(int i = 1; i < n; i++) {
            sum[i][0] += sum[i - 1][0] + array[i][0];
            sum[0][i] += sum[0][i - 1] + array[0][i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++)
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + array[i][j] - sum[i - 1][j - 1];
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start1 = Integer.parseInt(st.nextToken());
            int start2 = Integer.parseInt(st.nextToken());
            int end1 = Integer.parseInt(st.nextToken());
            int end2 = Integer.parseInt(st.nextToken());

            //s1 s2 e1 e2
            // 2 2 3 4
            //sum(3, 4) - sum(1, 3) - sum(4, 1) + sum(1, 1)
            //42 - 6 - 10 + 1 = 27

            if(start1 == end1 && start2 == end2)
                answer[i] = array[start1 - 1][start2 - 1];
            else if(start1 > 1 && start2 > 1)
                answer[i] = sum[end1 - 1][end2 - 1] - sum[end1 - 1][0] - sum[0][end2 - 1] + sum[0][0];
            else
                answer[i] = sum[end1 - 1][end2 - 1];
        }

        for(int i = 0; i < m; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
