package com.example.coding.탐색.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_7576 {
    static boolean visited[][];
    static Integer[][] graph;
    static Integer[][] time;
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
        time = new Integer[n][m];

        // 그래프 입력 받는다
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                time[i][j] = 0; //시간 그래프 초기화
            }
        }

        // 저장할 때부터 모든 토마토가 익었는지 판별
        boolean allClearSetting = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 0) {
                    allClearSetting = false;
                    break;
                }
            }
        }

        if(allClearSetting == true) {
            bw.write("0\n");
        } else {
            // bfs 실행
            bfs();

            // 토마토가 모두 익지 못하는 상황인지 확인
            boolean allClear = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(graph[i][j] == 0) {
                        bw.write("-1\n");
                        allClear = false;
                        break;
                    }
                }
                if(allClear == false) {
                    break;
                }
            }

            if(allClear == true) {
                int max = time[0][0];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(time[i][j] > max) {
                            max = time[i][j];
                        }
                    }
                }
                bw.write(max + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // graph 값이 1인 경우가 여러개가 있을 수 있기 때문
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            count += 1;

            int v[] = queue.poll();
            int vx = v[0];
            int vy = v[1];

            // 상하좌우 탐색
            for(int k = 0; k < 4; k++) {
                int nx = vx + dx[k];
                int ny = vy + dy[k];

                if(nx < n && ny < m && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = 1;
                    queue.add(new int[] {nx, ny});
                    // 시간 그래프 처리 : 전진 좌표는 이전 좌표에서 시간이 하나씩 증가한 것이므로 이전 좌표의 시간 + 1
                    time[nx][ny] = time[vx][vy] + 1;
                }
            }
        }
    }
}
