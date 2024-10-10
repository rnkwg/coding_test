package com.example.coding.codingChallenge.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class b_2823 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        char[][] graph = new char[r][c];  // 구역을 입력받을 그래프

        //마을 지도 입력 받기
        for(int j = 0; j < r; j++) {
            String input = br.readLine();
            for(int k = 0; k < c; k++) {
                graph[j][k] = input.charAt(k);
            }
        }

        // dfs 호출
        boolean flag = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(graph[i][j] == '.') {
                    // 길의 인접 4방향에서 길의 수가 1개 밖에 없으면 유턴을 해야함
                    if(dfs(graph, i, j) == 1) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if(flag)
            bw.write("1\n");
        else
            bw.write("0\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(char[][] graph, int x, int y) {
        // 인접한 4방향 탐색
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 인접한 4방향 중에서 길의 갯수 count
            if (nx < r && ny < c && nx >= 0 && ny >= 0 && graph[nx][ny] == '.') {
                count++;
            }
        }
        return count;
    }
}
