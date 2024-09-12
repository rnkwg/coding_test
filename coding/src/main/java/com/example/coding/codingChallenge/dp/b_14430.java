package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.StringTokenizer;

public class b_14430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][m + 1];
        int[][] graph = new int[n + 1][m + 1];  // 자원 정보 입력

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1)
                    dp[i][j] = 1;
            }
        }

        // dp
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        bw.write(dp[n][m] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
