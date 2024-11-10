package com.example.coding.doIt.graph;

import java.io.*;
import java.util.*;

/**
 * 이분 그래프: 인접한 정점끼리 서로 다른 색으로 칠해서
 *              모든 정점을 두가지 색으로만 칠할 수 있는 그래프
 */
public class b_1707 {
    static boolean flag = false;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 인접리스트 선언
            ArrayList<Integer> [] graph = new ArrayList[v + 1];
            check = new int[v + 1];
            boolean[] visited = new boolean[v + 1];
            for(int j = 0; j < v + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for(int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 양방향 그래프
                graph[a].add(b);
                graph[b].add(a);
            }

            for(int j = 1; j < v + 1; j++) {
                if(flag) {
                    sb.append("NO" + "\n");
                    break;
                } else if(!visited[j]) {
                    dfs(graph, visited, j);
                }
            }
            if(!flag) {
                sb.append("YES" + "\n");
            }

            flag = false;
        }

        bw.write(sb + " ");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int num) {
        // 방문처리
        visited[num] = true;

        // 인접한 8방향 반복
        for(int i = 0; i < graph[num].size(); i++) {
            int ni = graph[num].get(i);

            // dfs 호출 조건: 방문한적 없음
            // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
            // 다른 집합으로 처리하기 위해서 checked 배열을 생성
            // 인접노드는 호출노드와 그때 그때 다르게 처리하기 위해서 0 아니면 1 로 처리
            if(!visited[ni]) {
                check[ni] = (check[num] + 1) % 2;
                dfs(graph, visited, ni);
            } else if (check[ni] == check[num]) {
                flag = true;
            }
        }
    }
}
