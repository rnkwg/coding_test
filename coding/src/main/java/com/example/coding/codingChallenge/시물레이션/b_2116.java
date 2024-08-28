package com.example.coding.codingChallenge.시물레이션;

import java.io.*;
import java.util.*;

public class b_2116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][6];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < 6; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        for(int i = 0; i < 6; i++) {
            // 첫번째 주사위의 윗면에 따라서 아랫면이 정해진다
            // 정해진 아랫면 윗면을 제외하고 옆면 중에서 최댓값을 찾는다
            int sum = 0;
            int top = dice[0][i];
            int bottom = dice[0][getOppositeIndex(i)];

            // 옆면 중에서 최댓값을 더해준다
            sum += getMaxSide(i, getOppositeIndex(i), dice[0]);

            for(int j = 1; j < n; j++) {
                // 아래 주사위의 윗면 = 윗 주사위의 아랫면
                bottom = top;

                // 아래 인덱스와 위 인덱스 찾기 위해 -1 로 초기화
                int bottomIndex = -1; int topIndex = -1;
                for(int k = 0; k < 6; k++) {
                    if(dice[j][k] == bottom) {
                        // 윗면을 찾기 위한 인덱스 탐색
                        top = dice[j][getOppositeIndex(k)];

                        bottomIndex = k;
                        topIndex = getOppositeIndex(k);
                        break;
                    }
                }
                sum += getMaxSide(topIndex, bottomIndex, dice[j]);
            }
            // 더해진 옆면 중에서 가장 큰 최댓값을 찾는다
            maxSum = Math.max(maxSum, sum);
        }

        bw.write(maxSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 주사위에서 i 인덱스와 반대방향의 인덱스 찾기
    public static int getOppositeIndex(int i) {
        if(i == 0)
            return 5;
        else if(i == 1)
            return 3;
        else if(i == 2)
            return 4;
        else if(i == 3)
            return 1;
        else if(i == 4)
            return 2;
        else if(i == 5)
            return 0;
        return -1;
    }

    // 바닥과 천장을 제외한 옆 면 중에서 최댓값을 반환
    public static int getMaxSide(int top, int bottom, int[] dice) {
        int maxSide = 0;
        for(int i = 0; i < 6; i++) {
            if(i != top && i != bottom)
                maxSide = Math.max(maxSide, dice[i]);
        }
        return maxSide;
    }
}
