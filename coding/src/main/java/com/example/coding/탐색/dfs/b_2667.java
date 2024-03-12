package com.example.coding.탐색.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class b_2667 {
    static boolean[][] visited;
    static int[][] graph;
    static ArrayList<Integer> dangiCount;
    static int n;
    static int apart = 1;

    // 상하좌우 아파트 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n]; // 방문 저장 그래프
        graph = new int[n][n];   // 그래프
        dangiCount = new ArrayList<>(); // 단지내 아파트 수 저장할 배열

        //그래프 입력 받기
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        //그래프
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                //방문하지 않았고 아파트가 존재하면
                if(!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    dangiCount.add(apart);
                    //아파트 수 초기화
                    apart = 1;
                }
        }

        Collections.sort(dangiCount);

        bw.write(dangiCount.size() + "\n");
        for(int i = 0; i < dangiCount.size(); i++)
            bw.write(dangiCount.get(i) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j) {
        // 종료 조건 : 이미 방문했거나 아파트가 없다
        if(visited[i][j] || graph[i][j] == 0)
            return;

        visited[i][j] = true;
        //상하좌우 처리
        for(int m = 0; m < 4; m++) {
            int nx = i + dx[m];
            int ny = j + dy[m];

            // 경계값 안에 잘 들어왔고 방문한적 없고 아파트가 존재했을 해야 함
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == 1) {
                apart++;
                dfs(nx, ny);
            }
        }
    }
}
