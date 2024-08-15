package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int stairNum = Integer.parseInt(br.readLine());
        int[] stairArray = new int[stairNum + 1];
        int[] D = new int[stairNum + 1];
        for(int i = 1; i <= stairNum; i++)
            stairArray[i] = Integer.parseInt(br.readLine());

       // dp
        D[1] = stairArray[1];

        if(stairNum >= 2) {
            D[2] = stairArray[1] + stairArray[2];
            if(stairNum >= 3)
                D[3] = Math.max(stairArray[1], stairArray[2]) + stairArray[3];
            if(stairNum >= 4) {
                for (int i = 4; i <= stairNum; i++) {
                    D[i] = Math.max(D[i - 3] + stairArray[i - 1], D[i - 2]) + stairArray[i];
                }
            }
        }

        bw.write(D[stairNum] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
