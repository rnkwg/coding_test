package com.example.coding.codingChallenge.시물레이션;

import java.io.*;
import java.util.StringTokenizer;

public class b_5212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        char[][] newMap = new char[r][c];

        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // 50년 후의 지도
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'X') {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 경계를 넘어가거나 바다를 넘어가면 count + 1
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '.') {
                            count += 1;
                        }
                    }
                    if(count == 3 || count == 4)
                        newMap[i][j] = '.';
                    else
                        newMap[i][j] = 'X';
                } else {
                    newMap[i][j] = '.';
                }
            }
        }

        // 모든 섬을 포함하는 가장 작은 직사각형으로 지도의 크기 줄이기
        int minX = r;
        int minY = c;
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(newMap[i][j] == 'X') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                bw.write(newMap[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
