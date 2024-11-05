package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.StringTokenizer;

public class b_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        // dp
        dp[0] = 0;
            for(int i = 0; i < n - 1; i++) {
                // 밑의 코드로 dp 의 값이 변화가 되지 않았다면
                // 도달할 수 없는 곳이므로 스킵
                if(dp[i] == Integer.MAX_VALUE)
                    continue;

                // i에 도달한 순간 i + 1부터 i + array[i] 인덱스의 모든 값들에
                // dp[i] + 1 과 현재 dp[j] 값 비교하여 작은 값으로 바꾸어줌
                // 이때 경계값 주의
                for(int j = 1; j <= array[i]; j++) {
                    if(i + j < n) {
                        dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                    }
                }
            }

            // 값이 바뀌지 않았다면 도달하지 못했으니 -1
            if(dp[n - 1] == Integer.MAX_VALUE) {
                bw.write( "-1\n");
            } else {
                bw.write( dp[n - 1] + "\n");
            }

        bw.flush();
        bw.close();
        br.close();
    }
}
