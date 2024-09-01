package com.example.coding.codingChallenge.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_4803 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int caseNum = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 종료조건
            if(n == 0 && m == 0)
                break;

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            // 인접리스트 선언
            for(int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 입력받기
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            int treeCount = 0;

            for(int i = 1; i <= n; i++) {
                if(!visited[i] && isTree(i)) {
                    treeCount++;
                }
            }

            if(treeCount == 0)
                bw.write("Case " + caseNum + ": No trees.\n");
            else if(treeCount == 1)
                bw.write("Case " + caseNum + ": There is one tree.\n");
            else
                bw.write("Case " + caseNum + ": A forest of " + treeCount + " trees.\n");

            caseNum++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 트리 판별 : 노드 수 = 간선 수 + 1
    // dfs 알고리즘으로 이용하여 하나의 노드에서부터 연결되어 있는 모든 노드르 탐색
    // 해당 부분 트리가 트리로 판별 나면 return true
    // 에지의 경우 방향이 없는 양방향이므로 / 2
    public static boolean isTree(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int nodeCount = 0;
        int edgeCount = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodeCount++;
            for(int g : graph[node]) {
                edgeCount++;
                if(!visited[g]) {
                    visited[g] = true;
                    queue.add(g);
                }
            }
        }

        if(nodeCount - 1 == edgeCount / 2)
            return true;
        else return false;
    }
}
