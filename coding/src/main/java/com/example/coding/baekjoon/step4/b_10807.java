package com.example.coding.baekjoon.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int num[] = new int[T];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        for(int i = 0; i < T; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < T; i++) {
            if(v == num[i]) {
                count++;
            }
        }
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
