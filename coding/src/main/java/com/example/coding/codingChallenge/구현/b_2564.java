package com.example.coding.codingChallenge.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine().trim());
        int[] loc = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // 방향과 거리를 입력받는데
            // 거리는 처음 시작부터 시계방향으로 돌아서 걸리는 거리만큼 바꾸어 넣어줌

            if(dir == 1) {
                // 북쪽에 위치한 경우 그대로 넣어줌
                loc[i] = dist;
            } else if(dir == 2) {
                // 남쪽에 위치한 경우
                loc[i] = w * 2 + h - dist;
            } else if(dir == 3) {
                // 서쪽에 위치한 경우
                loc[i] = w * 2 + 2 * h - dist;
            } else if(dir == 4) {
                // 동쪽에 위치한 경우
                loc[i] = w + dist;
            }
        }

        // 최소거리 계산
        int maxDist = 0;
        for(int i = 0; i < n + 1; i++) {
            // 시계방향으로 회전했을 때 동근과 상점의 차이의 절댓값
            int clockDist = Math.abs(loc[n] - loc[i]);
            // 시계반대방향으로 회전했을 때 동근과 상점의 차이의 절댓값
            int antiClockDist = 2 * (w + h) - clockDist;
            // 둘중 최소거리를 누적합
            maxDist += Math.min(clockDist, antiClockDist);
        }

        bw.write(maxDist + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
