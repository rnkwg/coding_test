package com.example.coding.codingChallenge.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class b_11123 {
    // 상하좌우 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int sheepCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] sheepArray = new int[T];

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[H][W]; // 방문 저장 그래프
            char[][] graph = new char[H][W];   // 그래프

            //그래프 입력 받기
            for(int j = 0; j < H; j++) {
                String input = br.readLine();
                for(int k = 0; k < W; k++) {
                    graph[j][k] = input.charAt(k);
                }
            }

            // dfs 호출
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++)
                    //방문하지 않았고 양이 존재하면
                    if (!visited[j][k] && graph[j][k] == '#') {
                        dfs(graph, visited, H, W, j, k);
                        sheepCount++;
                    }
            }
            sheepArray[i] = sheepCount;
            sheepCount = 0;
        }

        for(int i = 0; i < sheepArray.length; i++)
            bw.write(sheepArray[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(char[][] graph, boolean[][] visited, int height, int width, int x, int y) {
        // dfs 종료 조건 : 이미 방문
        if(visited[x][y])
            return;

        // 방문처리
        visited[x][y] = true;

        // 상하좌우 반복
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // dfs 호출 조건 : 경계값 안에 잘 들어왔고 방문한적 없고 양이 존재
            if(nx < height && ny < width && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == '#') {
                dfs(graph, visited, height, width, nx, ny);
            }
        }
    }

}
