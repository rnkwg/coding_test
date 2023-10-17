package com.example.coding.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        /**
         * 입력
         * 5 3
         * 5 4 3 2 1
         * 1 3
         * 2 4
         * 5 5
         *
         * 출력
         * 12
         * 9
         * 1
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        int[] sum = new int[m];
        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            array[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            array[i] = Integer.parseInt(st1.nextToken());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
