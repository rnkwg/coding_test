package com.example.coding.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Integer.parseInt(st.nextToken());

        long[] array = new long[(int) n];
        long[] sum = new long[(int) n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            array[i] = i;
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
                answer[i] = sum[end - 1] - sum[start - 2];
            else
                answer[i] = sum[end - 1];
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
