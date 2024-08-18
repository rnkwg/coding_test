package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }

        // dp
        for(int i = 1; i < n; i++) {    //  i : 하나씩 비교하는 값들
            int max = 0;
            for(int j = 0; j < i; j++) {
                //  j : 비교하는 값보다 왼쪽에 있는 값들
                if(a[i] < a[j]) // 감소하는 수열이므로 비교 < 왼쪽
                    // d[j] 값 중 가장 큰 값을 넣어준다
                    max = Math.max(d[j], max);
            }
            // i 는 길이가 하나 증가한 것이므로 + 1
            d[i] = max + 1;
        }

        int max = 0;
        for(int i = 0; i < n; i++)
            max = Math.max(d[i], max);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
