package com.example.coding.codingChallenge.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];

        // 등수 입력 받기
        for(int i = 0; i < n; i++)
            rank[i] = Integer.parseInt(br.readLine());

        // 입력받은 등수를 오름차순 정렬
        Arrays.sort(rank);

        // 그리디
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.abs(i + 1 - rank[i]);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
