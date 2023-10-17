package com.example.coding.baekjoon.단계별.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1);

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int num[] = new int[n];
        for(int i1 = 0; i1 < n; i1++) {
            num[i1] = 0;
        }

        for(int i1 = 0; i1 < m; i1++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2);

            int i = Integer.parseInt(st2.nextToken());
            int j = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());

            while (i <= j) {
                num[i - 1] = k;
                i++;
            }
        }

        for(int i1 = 0; i1 < n; i1++) {
            bw.write(num[i1] + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
