package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] bottle = new long[(int) n];

        for(int i = 0; i < n; i++) {
            bottle[i] = Long.parseLong(br.readLine().trim());
        }

        // 이분탐색을 위해서 bottle 배열 오름차순 정렬
        Arrays.sort(bottle);

        // 이분탐색
        long start = 1; // 시작을 왜 1로 두어야 할까..
        long end = bottle[(int) (n - 1)];    // 가장 적은 막걸리
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (checkMac(bottle, mid, k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkMac(long[] bottle, long mid, long k) {
        if(mid == 0)
            return false;

        long sum = 0;
        for(int i = 0; i < bottle.length; i++) {
            sum += bottle[i] / mid;
        }

        if(sum >= k)
            return true;
        else
            return false;
    }
}
