package com.example.coding.doIt.탐색.bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1260 {
    static boolean visited[];
    static boolean[][] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        // 그래프 입력 받는다
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 양방향이므로 서로에 관계 표시를 해준다
            graph[s][e] = true;
            graph[e][s] = true;
        }

        dfs(start);
        stringBuilder.append("\n");
        visited = new boolean[n + 1];
        bfs(start);

        bw.write(stringBuilder + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        stringBuilder.append(v + " ");
        for(int i = 1; i < visited.length; i++) {
            if(!visited[i] && graph[v][i])
                dfs(i);
        }
    }

    static void bfs(int v) {
        queue.add(v);

        visited[v] = true;

        while(!queue.isEmpty()) {
            v = queue.poll();
            stringBuilder.append(v + " ");

            for(int i = 1; i < visited.length; i++) {
                if(!visited[i] && graph[v][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
