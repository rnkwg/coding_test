package com.example.coding.doIt.탐색.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long start = 1;
        long end = k;
        long answer = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            // 중간 값보다 작은 수는 몇 개인지 계산.
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(middle / i, n);  // 작은 수를 카운트하는 핵심로직
            }
            if (cnt < k) {
                start = middle + 1;
            } else {
                answer = middle;  // 현재 단계의 중간 값을 정답 변수에 저장
                end = middle - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
