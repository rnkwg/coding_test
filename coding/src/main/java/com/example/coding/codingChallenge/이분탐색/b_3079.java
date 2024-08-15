package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] timeArray = new long[n];
        long timeMax = 0;
        for(int i = 0; i < n; i++) {
            timeArray[i] = Long.parseLong(br.readLine());
            if(timeMax < timeArray[i])
                timeMax = timeArray[i];
        }

        // 이분 탐색 위한 심사 시간 오름차순 정렬
        Arrays.sort(timeArray);

        // 심사 시간 이분 탐색
        long start = 1;
        long end = timeMax * m; // 가장 오래 걸리는 시간 * 사람 수
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;   // 각 처리대가 처리할 수 있는 사람 수의 합

            for(int i = 0; i < n; i++) {
                // 각 심사대가 처리할 수 있는 사람 수
                long count = mid / timeArray[i];
                if(sum >= m)
                    break;
                sum += count;
            }

            // 처리대가 처리할 수 있는 사람 수의 합 >= 사람 수 이므로
            // 왼쪽 묶음 탐색
            if(sum >= m) {
                end = mid - 1;
            } else {
                // 처리대가 처리할 수 있는 사람 수의 합 < 사람 수 이므로
                // 오른쪽 묶음 탐색
                start = mid + 1;
            }
        }

        bw.write(start + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
