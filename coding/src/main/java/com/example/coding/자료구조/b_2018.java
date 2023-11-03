package com.example.coding.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Integer.parseInt(st.nextToken());

//        long[] array = new long[(int) n + 1];
//        long[] sum = new long[(int) n + 1];
        int count = 1;
        int sum = 1;
        int start = 1;
        int end = 1;

//        for(int i = 0; i <= n; i++) {
//            array[i] = i;
//        }
//
//        sum[0] = array[0];
//        for(int i = 1; i <= n; i++) {
//            sum[i] = sum[i - 1] + array[i];
//        }

//        for(int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//
//            if(start > 1)
//                answer[i] = sum[end - 1] - sum[start - 2];
//            else
//                answer[i] = sum[end - 1];
//        }

        /**
         * array
         * 0 1 2 3 4 5
         *
         * sum
         * 0 1 3 6 10 15
         */
        while(end < n + 1) {
            partSum = (int) (sum[end] - sum[start - 1]);

            //partSum == n 이면
            //
            if(partSum == n) {
                end++;
            } else if(partSum < n) {
                start++;
            } else {
                end++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
