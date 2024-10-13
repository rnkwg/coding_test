package com.example.coding.codingChallenge.graph;

import java.io.*;
import java.util.StringTokenizer;

public class b_13901 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 방의 크기 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][] graph = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        // 장애물 입력 받기
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int kr = Integer.parseInt(st.nextToken());
            int kc = Integer.parseInt(st.nextToken());
            graph[kr][kc] = 1;  // 장애물은 1로 표시
        }

        // 시작위치 입력 받기
        st = new StringTokenizer(br.readLine().trim());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        // 이동방향 입력 받기
        st = new StringTokenizer(br.readLine().trim());
        int d[] = new int[4];
        for(int i = 0; i < 4; i++)
            d[i] = Integer.parseInt(st.nextToken()) - 1;

        bw.write(dfs(graph, visited, sr, sc, d) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static String dfs(int[][] graph, boolean[][] visited, int x, int y, int[] d) {
        String answer = "";
        visited[x][y] = true;
        int i = 0;
        boolean check = false;

        while(true) {
            // 인접한 4방향 탐색
            int count = 0;
            while(true) {
                // 입력받은 이동방향 순서대로 이동한다
                int nx = x + dx[d[i % 4]];
                int ny = y + dy[d[i % 4]];

                // 이동 가능 조건
                // 1. 경계값 만족
                // 2. 장애물이 존재하지 않음
                // 3. 방문한 적 없음
                // 이동 가능한 경우 계속해서 같은 방향으로 이동
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && graph[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    x = nx;
                    y = ny;
                    count = 0;  // 이동한 경우에는 다시 탐색 횟수 초기화
                } else if(count == 4) { // 탐색 실패가 4번인 경우 탐색 중지
                    check = true;
                    break;
                } else {
                    count++;
                    i++;
                }
            }

            // 인접한 4방향을 탐색 완료 했는데 한번도 이동을 하지 못한 경우
            // 마지막 좌표로 return
            if(check) {
                answer = x + " " + y;
                break;
            }
        }

        return answer;
    }
}
