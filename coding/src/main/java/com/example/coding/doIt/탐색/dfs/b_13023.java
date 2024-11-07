package com.example.coding.doIt.탐색.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_13023 {
    static boolean visited[];
    static int m;
    static boolean arrive = false;

    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = 1;

        visited = new boolean[n]; // 방문 저장 배열
        graph = new ArrayList[n];   // 연결된 관계 저장할 그래프
        for(int i = 0; i < n; i++) {
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

        for(int i = 0; i < n; i++) {
            dfs(i, 1);
            if(arrive)
                break;
        }

        if(arrive)
            bw.write("1\n");
        else
            bw.write("0\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int v, int count) {
        if(count == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[v] = true;
        for(int i : graph[v]) {
            if(!visited[i])
                dfs(i, count + 1);
        }
        visited[v] = false;
    }
}
