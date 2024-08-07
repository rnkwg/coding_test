package com.example.coding.codingChallenge.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class b_16937 {
    static int[][] sticker;
    static int h;
    static int w;
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        // 스티커를 입력받으면서 스티커 높, 넓 <= 모눈종이의 높, 넓 확인
        // 조건에 해당하는 스티커와 해당 스티커 면적만 2차원 배열에 넣음
        sticker = new int[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ri = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            if((ri <= h || ri <= w) && (ci <= h || ci <= w)) {
                sticker[i][0] = ri;
                sticker[i][1] = ci;
                sticker[i][2] = ri * ci;
            }
        }

        // 스티커 두개 선택하여 모눈종이에 붙을 수 있는지 확인 후 max 출력
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(sticker[i][0] == 0 || sticker[j][0] == 0)
                    continue;
                // 모두 회전하지 않은 경우
                if(isStick(sticker[i][0], sticker[j][0], sticker[i][1], sticker[j][1]) && max < sticker[i][2] + sticker[j][2])
                    max = sticker[i][2] + sticker[j][2];
                // 첫번째 스티커만 90도 회전한 경우
                if(isStick(sticker[i][1], sticker[j][0], sticker[i][0], sticker[j][1]) && max < sticker[i][2] + sticker[j][2])
                    max = sticker[i][2] + sticker[j][2];
                // 두번째 스티커만 90도 회전한 경우
                if(isStick(sticker[i][0], sticker[j][1], sticker[i][1], sticker[j][0]) && max < sticker[i][2] + sticker[j][2])
                    max = sticker[i][2] + sticker[j][2];
                if(isStick(sticker[i][1], sticker[j][1], sticker[i][0], sticker[j][0]) && max < sticker[i][2] + sticker[j][2])
                    max = sticker[i][2] + sticker[j][2];
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 스티커를 가로, 세로로 붙일 때 모눈종이에 붙을 수 있는지 확인
    private static boolean isStick(int r1, int r2, int c1, int c2) {
        // 가로로 붙일 때
        if(c1 + c2 <= h && Math.max(r1, r2) <= w)
            return true;
        // 세로로 붙일 때
        if (r1 + r2 <= w && Math.max(c1, c2) <= h)
            return true;
        return false;
    }
}
