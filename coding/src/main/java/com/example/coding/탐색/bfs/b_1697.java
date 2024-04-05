package com.example.coding.탐색.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1697 {
    static boolean visited[];
    static Integer[] graph;
    static int n;
    static int m;
    static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new Integer[100001];
        visited = new boolean[100001];

        if(n == m) {
            System.out.println("0");
        } else {
            bfs(n);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int i) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        visited[i] = true;
        graph[i] = 0;

        while(!queue.isEmpty()) {
            int v = queue.poll();

            // v*2, v+1, v-1 탐색
            for(int k = 0; k < 3; k++) {
                int nv;
                if(k == 0) {
                    nv = v * 2;
                } else if(k == 1) {
                    nv = v + 1;
                } else {
                    nv = v - 1;
                }

                // 목표 m 도달
                if(nv == m) {
                    graph[nv] = graph[v] + 1;
                    System.out.println(graph[nv]);
                    return;
                }

                if(nv < 100001 && nv >= 0 && !visited[nv]) {
                    visited[nv] = true;
                    queue.add(nv);
                    graph[nv] = graph[v] + 1;
                }
            }
        }
    }
}
