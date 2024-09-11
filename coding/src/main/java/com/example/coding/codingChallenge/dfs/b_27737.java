package com.example.coding.codingChallenge.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class b_27737 {
    // 상하좌우 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;
    static int m;
    static int k;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][n]; // 방문 저장 그래프
        int[][] graph = new int[n][n];  // 버섯 입력받을 그래프

        //그래프 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int use = 0;
        // dfs 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(m == 0) {
                    break;
                }
                //방문하지 않았고 버섯이 자랄 수 있는 칸이면
                if (!visited[i][j] && graph[i][j] == 0) {
                    count = 0;
                    dfs(graph, visited, i, j);
                    use++;
                }
            }
        }

        if(use == 0 || use > m) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write("POSSIBLE\n" + (m - use) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[][] graph, boolean[][] visited, int x, int y) {
        // dfs 종료 조건 : 이미 방문했거나 연속 탐색한 갯수가 k에 도달했을때
        if(visited[x][y] || count == k)
            return;

        // 방문처리
        visited[x][y] = true;
        count += 1;

        // 인접한 4방향 반복
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // dfs 호출 조건 : 경계값 안에 잘 들어왔고 버섯농사가 가능한 땅
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == 0) {
                 dfs(graph, visited, nx, ny);
            }
        }
    }
}
