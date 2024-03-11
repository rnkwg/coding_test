package com.example.coding.탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_2468 {
    static boolean[][] visited;
    static int[][] graph;
    static ArrayList<Integer> areaCount;
    static int n;
    static int area = 0;

    // 상하좌우 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] height = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        areaCount = new ArrayList<>(); // 배추 수 저장할 배열
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];   // 그래프
        visited = new boolean[n][n]; // 방문 저장 그래프

        // height 배열 초기화
        for(int i = 0; i < height.length; i++)
            height[i] = 0;

        // 그래프 입력 받기
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                height[graph[i][j]]++;
            }
        }

        for(int i = 1; i < 101; i++) {
            if(height[i] == 0) continue;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    //방문하지 않았고 그래프가
                    if (!visited[j][k] && graph[j][k] > i) {
                        area++;
                        dfs(j, k, i);
                    }
                }
            }

            areaCount.add(area);
            area = 0;
            refreshVisited();
        }

        int max = areaCount.get(0);
        for(int i = 0; i < areaCount.size(); i++) {
            if(max < areaCount.get(i))
                max = areaCount.get(i);
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j, int height) {
        // 종료 조건 : 이미 방문했거나 높이가 작거나 같다
        if(visited[i][j] || graph[i][j] <= height)
            return;

        visited[i][j] = true;
        //상하좌우 처리
        for(int m = 0; m < 4; m++) {
            int nx = i + dx[m];
            int ny = j + dy[m];

            // 경계값 안에 잘 들어왔고 방문한적 없고 높이가 더 높아야 한다
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
    }

    static void refreshVisited() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                visited[i][j] = false;
    }
}
