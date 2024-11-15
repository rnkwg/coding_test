package com.example.coding.doIt.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_2252 {
    // 위상정렬 알고리즘 구현을 위해서는 stack 을 이용
    // 탐색을 끝낸 노드를 가장 나중 순서에 넣기 위해서 후입선출 특성 필요
    // 노드 탐색이 끝난 후 스택에 있는 노드들을 꺼내면 위상정렬 순서가 된다
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접리스트 선언
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int j = 0; j < n + 1; j++) {
            graph[j] = new ArrayList<>();
        }

        boolean[] visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i])
                dfs(graph, visited, i);
        }

        while(!stack.isEmpty())
            bw.write(stack.pop() + " ");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int num) {
        // 방문처리
        visited[num] = true;

        // 인접한 그래프 탐색
        for(int i = 0; i < graph[num].size(); i++) {
            int ni = graph[num].get(i);

            if(!visited[ni]) {
                dfs(graph, visited, ni);
            }
        }

        stack.add(num);
    }
}
