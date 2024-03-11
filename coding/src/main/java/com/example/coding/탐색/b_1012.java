package com.example.coding.탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_1012 {
    static boolean[][] visited;
    static boolean[][] graph;
    static ArrayList<Integer> cabCount;
    static int n;
    static int cab = 0;

    // 상하좌우 배추 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        cabCount = new ArrayList<>(); // 배추 수 저장할 배열
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int exCount = Integer.parseInt(st.nextToken());

            visited = new boolean[height][width]; // 방문 저장 그래프
            graph = new boolean[height][width];   // 그래프

            //그래프 입력 받기
            for (int j = 0; j < exCount; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph[e][s] = true;
            }

            //그래프
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++)
                    //방문하지 않았고 배추가 존재하면
                    if (!visited[j][k] && graph[j][k] == true) {
                        cab++;
                        dfs(j, k, width, height);
                    }
            }

            cabCount.add(cab);
            // 배추 초기화
            cab = 0;
        }

        for(int i = 0; i < cabCount.size(); i++)
            bw.write(cabCount.get(i) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j, int width, int height) {
        // 종료 조건 : 이미 방문했거나 배추가 없다
        if(visited[i][j] || graph[i][j] == false)
            return;

        visited[i][j] = true;
        //상하좌우 처리
        for(int m = 0; m < 4; m++) {
            int nx = i + dx[m];
            int ny = j + dy[m];

            // 경계값 안에 잘 들어왔고 방문한적 없고 배추가 존재해야 한다
            if(nx < height && ny < width && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == true) {
                dfs(nx, ny, width, height);
            }
        }
    }
}
