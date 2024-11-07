package com.example.coding.doIt.탐색.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class b_1987 {
    static boolean[][] visited;
    static char[][] graph;
    static int r;
    static int c;
    static int max = 0;

    // 상하좌우 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    // 이미 탐색한 알파벳 판별 위한 배열
    static boolean[] alphabet = new boolean[30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];   // 그래프
        visited = new boolean[r][c]; // 방문 저장 그래프

        // 그래프 입력 받기
        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        // (0, 0) 에서 한번만 dfs 실행
        dfs(0, 0, 1);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int i, int j, int count) {
        // 종료 조건 : 이미 방문했던 알파벳이다
        if(alphabet[graph[i][j] - 65])
            return;

        // 최대 값 찾기 위해서 계속 비교해준다
        if(max < count)
            max = count;

        // visited 배열 대신에 alphabet 방문 처리만 해준다
        alphabet[graph[i][j] - 65] = true;

        //상하좌우 처리
        for(int m = 0; m < 4; m++) {
            int nx = i + dx[m];
            int ny = j + dy[m];

            // 경계값 안에 잘 들어왔고 방문했던 알파벳이 아니다
            if(nx < r && ny < c && nx >= 0 && ny >= 0 && !alphabet[graph[nx][ny] - 65]) {
                dfs(nx, ny, count + 1);
                // 다시 돌아왔을 때 방문 처리를 취소해준다
                alphabet[graph[nx][ny] - 65] = false;
            }
        }
    }
}
