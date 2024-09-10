package com.example.coding.codingChallenge.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class b_4963 {
    // 인접한 8방향 탐색 위한 배열
    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int islandCount = 0;

            if(h == 0 && w == 0)
                break;

            boolean[][] visited = new boolean[h][w]; // 방문 저장 그래프
            int[][] graph = new int[h][w];   // 입력받는 지도

            //그래프 입력 받기
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dfs 호출
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++)
                    //방문하지 않았고 땅이 존재하면
                    if (!visited[j][k] && graph[j][k] == 1) {
                        dfs(graph, visited, h, w, j, k);
                        islandCount++;
                    }
            }

            bw.write(islandCount + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[][] graph, boolean[][] visited, int height, int width, int x, int y) {
        // dfs 종료 조건 : 이미 방문
        if(visited[x][y])
            return;

        // 방문처리
        visited[x][y] = true;

        // 인접한 8방향 반복
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // dfs 호출 조건 : 경계값 안에 잘 들어왔고 방문한적 없고 땅이 존재
            if(nx < height && ny < width && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == 1) {
                dfs(graph, visited, height, width, nx, ny);
            }
        }
    }
}
