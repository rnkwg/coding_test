package com.example.coding.codingChallenge.graph;

import java.io.*;
import java.util.*;

public class b_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> [] tree = new ArrayList[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        // 인접리스트 선언
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 입력받기
        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            // 인덱스 처리를 위하여 -1 로 값 조정
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree[a].add(b);
            tree[b].add(a);
        }

        // dfs 탐색
        dfs(0, tree, visited, parent);

        for(int i = 1; i < n; i++) {
            bw.write((parent[i] + 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int num, ArrayList<Integer>[] tree, boolean[] visited, int[] parent) {
        // 방문처리
        visited[num] = true;

        for(int i : tree[num]) {
            if(!visited[i]) {
                // 부모 배열에 넣어준다
                parent[i] = num;
                dfs(i, tree, visited, parent);
            }
        }
    }
}
