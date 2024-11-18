package com.example.coding.doIt.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_1516 {
    // 위상정렬 알고리즘 구현을 위해서는 stack 을 이용
    // 탐색을 끝낸 노드를 가장 나중 순서에 넣기 위해서 후입선출 특성 필요
    // 노드 탐색이 끝난 후 스택에 있는 노드들을 꺼내면 위상정렬 순서가 된다
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n + 1];    // 각 건물마다 걸린 시간 저장 배열
        ArrayList<Integer> [] graph = new ArrayList[n + 1]; // 건물을 짓는데에 선행 건물 그래프
        for(int j = 0; j < n + 1; j++) {
            graph[j] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            // 건물을 짓는데 걸리는 시간
            time[i] = Integer.parseInt(st.nextToken());

            // 건물을 짓기 위해 먼저 지어져야 하는 건물의 번호
            int j = 0;
            int firstBuilding = Integer.parseInt(st.nextToken());
            while(firstBuilding != -1) {
                graph[firstBuilding].add(i);
                firstBuilding = Integer.parseInt(st.nextToken());
            }
        }

        // 위상정렬 순서 계산
        for(int i = 1; i <= n; i++) {
            if(!visited[i])
                dfs(graph, visited, i);
        }

        int[] result = new int[n + 1];
        // dp
        while (!stack.isEmpty()) {
            // 위상정렬 순서대로 꺼낸다
            int order = stack.pop();

            // 해당 건물을 짓는데에 필요한 시간과 다른 선행 경로로 처리 된 값 중 큰 값을 넣는다
            result[order] = Math.max(time[order], result[order]);

            // 해당 건물에 연결된 모든 건물들에게
            // 다른 선행 경로로 처리 된 값과
            // 해당 건물 짓는데에 걸리는 시간 + 선행 건물의 결과 를 비교해 큰 값을 넣는다
            for(int next : graph[order]) {
                result[next] = Math.max(result[next], result[order] + time[next]);
            }
        }

        for(int i = 1; i <= n; i++)
            bw.write(result[i] + "\n");

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
