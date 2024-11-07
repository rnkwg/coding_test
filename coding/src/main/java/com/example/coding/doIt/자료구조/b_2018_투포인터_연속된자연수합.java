package com.example.coding.doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_2018_투포인터_연속된자연수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Integer.parseInt(st.nextToken());

        int count = 1;
        int sum = 1;
        int start = 1;
        int end = 1;

        while(end < n) {
            if(sum == n) {
                count++;
                end++;
                sum += end;
            } else if(sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
