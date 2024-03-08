package com.example.coding.탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_2606 {
    static boolean visited[];
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1]; // 방문 저장 배열
        graph = new ArrayList[n + 1];   // 연결된 관계 저장할 그래프

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 양방향이므로 서로에 더해준다
            graph[s].add(e);
            graph[e].add(s);
        }

        dfs(1);

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for(int i : graph[v]) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
