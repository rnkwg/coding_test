package com.example.coding.codingChallenge.dfs;

import java.io.*;

public class b_10026 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        char[][] graph = new char[n][n];  // 구역을 입력받을 그래프

        //그래프 입력 받기
        for(int j = 0; j < n; j++) {
            String input = br.readLine();
            for(int k = 0; k < n; k++) {
                graph[j][k] = input.charAt(k);
            }
        }

        // dfs 호출
        boolean[][] visited = new boolean[n][n]; // 방문 저장 그래프
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //방문하지 않은 경우에
                if (!visited[i][j]) {
                    count++;
                    dfs(graph, visited, i, j);
                }
            }
        }

        // colorDfs 호출
        visited = new boolean[n][n]; // 방문 저장 그래프
        int colorCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //방문하지 않은 경우에
                if (!visited[i][j]) {
                    colorCount++;
                    colorDfs(graph, visited, i, j);
                }
            }
        }

        bw.write(count + " " + colorCount);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(char[][] graph, boolean[][] visited, int x, int y) {
        // dfs 종료 조건 : 이미 방문
        if(visited[x][y])
            return;

        // 방문처리
        visited[x][y] = true;

        // 인접한 4방향 반복
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // dfs 호출 조건 : 경계값 안에 잘 들어왔고 주변의 색상과 원래 색상이 동일할때
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny] && graph[nx][ny] == graph[x][y]) {
                dfs(graph, visited, nx, ny);
            }
        }
    }

    public static void colorDfs(char[][] graph, boolean[][] visited, int x, int y) {
        // dfs 종료 조건 : 이미 방문
        if(visited[x][y])
            return;

        // 방문처리
        visited[x][y] = true;

        // 인접한 4방향 반복
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // dfs 호출 조건 : 경계값 안에 잘 들어왔고 주변의 색상이 원래 색상과 동일할때
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && !visited[nx][ny] && colorCheck(graph[nx][ny], graph[x][y])) {
                colorDfs(graph, visited, nx, ny);
            }
        }
    }

    public static boolean colorCheck(char graph, char graphN) {
        if(graph == graphN)
            return true;
        else if(graph != 'B' && graphN != 'B')
            return true;
        else
            return false;
    }
}
