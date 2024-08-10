package com.example.coding.codingChallenge.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_17086 {
    // 인접한 8방향 탐색 위한 배열
    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        int[][] distanceGraph = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        // 그래프 입력 받기 및 상어 위치를 큐에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {  // 상어가 있는 위치
                    queue.offer(new int[]{i, j});
                    distanceGraph[i][j] = 0;  // 상어 위치는 거리 0
                } else {
                    distanceGraph[i][j] = -1;  // 빈 칸은 -1로 초기화
                }
            }
        }

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            // 인접한 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                // 경계 조건 및 아직 방문하지 않은 경우
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (distanceGraph[nx][ny] == -1) {
                        distanceGraph[nx][ny] = distanceGraph[qx][qy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 거리의 최댓값 찾기
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDistance = Math.max(maxDistance, distanceGraph[i][j]);
            }
        }

        bw.write(maxDistance + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
