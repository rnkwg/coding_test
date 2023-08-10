package com.example.coding.baekjoon.step4;

import java.io.*;
import java.util.StringTokenizer;

public class b_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1);

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int num[] = new int[n];
        for(int i1 = 0; i1 < n; i1++) {
            num[i1] = (i1 + 1);
        }

        for(int i1 = 0; i1 < m; i1++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2);

            int a = Integer.parseInt(st2.nextToken()) - 1;
            int b = Integer.parseInt(st2.nextToken()) - 1;

            while (a < b) {
                int temp = num[a];
                num[a++] = num[b];
                num[b--] = temp;
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

