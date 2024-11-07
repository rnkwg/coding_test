package com.example.coding.doIt.자료구조;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1940_투포인터_연속하지않은자연수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        long m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        Arrays.sort(array);

        while(start < end) {
            if(sum == m) {
                count++;
                end++;
                sum = array[end] + array[start];
            } else if(sum > m) {
                sum -= array[start];
                start++;
            } else {
                end++;
                sum += array[end];
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
