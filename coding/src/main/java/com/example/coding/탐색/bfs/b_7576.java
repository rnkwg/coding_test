package com.example.coding.탐색.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_7576 {
    static boolean visited[][];
    static Integer[][] graph;
    static Integer[][] distance;
    static StringBuilder stringBuilder = new StringBuilder();
    static int count = 0;

    // 상하좌우 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new Integer[n][m];
        visited = new boolean[n][m];
//        distance = new Integer[n][m];

        // 그래프 입력 받는다
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
//                distance[i][j] = 0; //거리 그래프 초기화
            }
        }

        bfs(0, 0);

        bw.write((distance[n - 1][m - 1] + 1 )+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int v[] = queue.poll();
            int vx = v[0];
            int vy = v[1];

            // 상하좌우 탐색
            for(int k = 0; k < 4; k++) {
                int nx = vx + dx[k];
                int ny = vy + dy[k];

                if(nx < n && ny < m && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                    // 거리 그래프 처리 : 전진 좌표는 이전 좌표에서 거리가 하나씩 증가한 것이므로 이전 좌표의 거리 + 1
                    distance[nx][ny] = distance[vx][vy] + 1;
                }
            }
        }
    }
}
