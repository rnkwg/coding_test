package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.StringTokenizer;

public class b_1577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][m + 1];
        boolean[][][] road = new boolean[n + 1][m + 1][2];  // 도로 정보를 표시

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == c) { // 세로로 연결된 도로
                if (b < d && b < m) road[a][b][0] = true;
                else if (b > d && d < m) road[a][d][0] = true;
            } else if (b == d) { // 가로로 연결된 도로
                if (a < c && a < n) road[a][b][1] = true;
                else if (a > c && c < n) road[c][b][1] = true;
            }
        }

        // dp
        dp[0][0] = 1;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
               if(i > 0 && !road[i - 1][j][1])
                   dp[i][j] += dp[i - 1][j];
               if(j > 0 && !road[i][j - 1][0])
                   dp[i][j] += dp[i][j - 1];
            }
        }

        bw.write(dp[n][m] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
