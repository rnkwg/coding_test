package com.example.coding.doIt.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1976 {
    static boolean flag = false;
    static ArrayList<Integer> order = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());

        int[][] graph = new int[n][n];
        int[] plan = new int[m];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        bfs(graph, plan);

        // 가능한 한 탐색을 해야 하기 때문에 bfs 탐색을 진행
        // 계획 중에서 bfs 탐색의 결과에 없는 도시가 있다면
        // 해당 도시는 재방문을 하더라도 아예 방문이 불가능한 도시로 판별
        for(int i = 0; i < plan.length; i++) {
            if(!order.contains(plan[i])) {
                flag = true;
                break;
            }
        }

        if(flag) {
            bw.write("NO\n");
        } else {
            bw.write("YES\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int[][] graph, int[] plan) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        // 여행 계획의 첫번째 도시부터 큐에 삽입
        // 방문 처리
        queue.offer(plan[0]);
        visited[plan[0]] = true;

        // bfs 수행
        // 도시 사이에 연결이 되어 있는지만 확인
        while(!queue.isEmpty()) {
            int q = queue.poll();
            order.add(q);
            for(int i = 0; i < graph[q].length; i++) {
                if(graph[q][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
