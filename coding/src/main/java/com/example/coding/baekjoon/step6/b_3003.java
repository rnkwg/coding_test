package com.example.coding.baekjoon.step6;

import java.io.*;
import java.util.StringTokenizer;

public class b_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] c = {1, 1, 2, 2, 2, 8};
        int[] arr = new int[6];

        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] = c[i] - arr[i];
        }

        for(int i = 0; i < 6; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
