package com.example.coding.doIt.탐색.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int array[] = new int[n];
        int target = 0;
        int answer = 0;

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = n - 1; i >= 0; i--) {
            if(k < array[i])
                continue;
            answer += k / array[i];
            k = k % array[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
