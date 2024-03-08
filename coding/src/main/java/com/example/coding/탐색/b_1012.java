package com.example.coding.탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class b_1012 {
    static boolean[][] visited;
    static int[][] graph;
    static ArrayList<Integer> cabCount;
    static int n;
    static int cab = 1;

    // 상하좌우 배추 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n]; // 방문 저장 그래프
        graph = new int[n][n];   // 그래프
        cabCount = new ArrayList<>(); // 배추 수 저장할 배열

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
                //방문하지 않았고 배추가 존재하면
                if(!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    cabCount.add(cab);
                    //배추 수 초기화
                    cab = 1;
                }
        }

        Collections.sort(cabCount);

        bw.write(cabCount.size() + "\n");
        for(int i = 0; i < cabCount.size(); i++)
            bw.write(cabCount.get(i) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j) {
        // 종료 조건 : 이미 방문했거나 배추가 없다
        if(visited[i][j] || graph[i][j] == 0)
            return;

        visited[i][j] = true;
        //상하좌우 처리
        for(int m = 0; m < 4; m++) {
            int nx = i + dx[m];
            int ny = j + dy[m];

            // 경계값 안에 잘 들어왔고 방문한적 없고 배추가 존재했을 해야 함
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == 1) {
                cab++;
                dfs(nx, ny);
            }
        }
    }
}
