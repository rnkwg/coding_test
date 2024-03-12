package com.example.coding.탐색.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_2178 {
    static boolean visited[][];
    static Integer[][] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new Integer[n][m];
        visited = new boolean[n][m];

        // 그래프 입력 받는다
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
           for(int j = 0; j < m; j++)
               if(!visited[i][j] && graph[i][j] == 1)
                bfs(i, j);
        }

        bw.write(stringBuilder + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
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
