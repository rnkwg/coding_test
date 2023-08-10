package com.example.coding.baekjoon.step5;

import java.io.*;
import java.util.StringTokenizer;

public class b_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String st = br.readLine();
            StringTokenizer str = new StringTokenizer(st);

            int n = Integer.parseInt(str.nextToken());
            String s = str.nextToken();

            for(int j = 0; j < s.length(); j++) {
                for(int k = 0; k < n; k++) {
                    bw.write(s.charAt(j) + "");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
