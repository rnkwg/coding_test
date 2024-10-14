package com.example.coding.codingChallenge.구현;

import java.io.*;

public class b_3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        int max = -1;

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                // 가로 방향으로 하나씩 교환하기
                char temp;
                temp = map[i][j + 1];
                map[i][j + 1] = map[i][j];
                map[i][j] = temp;

                // 같은 색으로 이루어진 가장 긴 연속의 갯수 찾기
                int count = getMax(map, n);
                max = Math.max(count, max);

                // 다시 원위치
                temp = map[i][j + 1];
                map[i][j + 1] = map[i][j];
                map[i][j] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                // 세로 방향으로 하나씩 교환하기
                char temp;
                temp = map[j + 1][i];
                map[j + 1][i] = map[j][i];
                map[j][i] = temp;

                // 같은 색으로 이루어진 가장 긴 연속의 갯수 찾기
                int count = getMax(map, n);
                max = Math.max(count, max);

                // 다시 원위치
                temp = map[j + 1][i];
                map[j + 1][i] = map[j][i];
                map[j][i] = temp;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMax(char map[][], int n) {
        int max = -1;

        // 가로로 탐색
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 0; j < n - 1; j++) {
                if(map[i][j] == map[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        // 세로로 탐색
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 0; j < n - 1; j++) {
                if(map[j][i] == map[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        return max;
    }
}
