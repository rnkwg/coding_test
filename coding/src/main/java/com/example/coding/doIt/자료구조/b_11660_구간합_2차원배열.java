package com.example.coding.doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_11660_구간합_2차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];
        int[] answer = new int[m + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + array[i][j] - sum[i - 1][j - 1];
        }

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

        for (int k = 1; k <= m; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            answer[k] = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
        }

        for(int i = 1; i <= m; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
