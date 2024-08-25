package com.example.coding.codingChallenge.시물레이션;

import java.io.*;
import java.util.StringTokenizer;

public class b_10157  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(br.readLine());
        int[][] seats = new int[C][R];

        int x = 0;
        int y = 0;
        int direction = 0;
        int num = 1;    // seats 배열에 넣을 숫자
        int dx[] = {0, 1, 0, -1};   // 우 하 좌 상
        int dy[] = {1, 0, -1, 0};

        if(k > (long) C * R) {
            bw.write("0" + "\n");
        } else {
            while (num != k) {
                seats[x][y] = num;

                // 다음 좌표 계산
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                // 경계를 넘어가거나 이미 채워진 경우 방향 전환
                if (nx < 0 || ny < 0 || nx >= C || ny >= R || seats[nx][ny] != 0) {
                    direction = (direction + 1) % 4; // 방향 전환
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }

                x = nx;
                y = ny;
                num++;
            }
            bw.write((x + 1) + " " + (y + 1));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
