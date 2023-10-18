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
         * 5 4 3 2 1 : array
         * 5 9 12 14 15 : sum
         * 5 9 7 5 3
         *
         * 1 3 : 12
         * 2 4 : 9
         * 5 5 : 1
         *
         * 출력
         * 12
         * 9 = sum[3] - array[0]
         * 1 = sum[4] - array[4]
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        int[] sum = new int[n];
        int[] answer = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = array[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + array[i];
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start > 1)
                answer[i] = sum[end - 1] - sum[start - 1];
            else
                answer[i] = sum[end - 1];
        }

        for(int i = 0; i < m; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
