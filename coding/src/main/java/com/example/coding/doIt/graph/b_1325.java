package com.example.coding.doIt.graph;

import java.io.*;
import java.util.*;

public class b_1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> [] trust = new ArrayList[n + 1];

        // 인접리스트 선언
        for(int i = 0; i < n + 1; i++) {
            trust[i] = new ArrayList<>();
        }

        // 신뢰관계 입력받기
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trust[a].add(b);
        }

        int[] dest = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            bfs(trust, new boolean[n + 1], i, dest);
        }

        StringBuilder sb = new StringBuilder();
        int max = dest[1];
        // 가장 큰 max 값 탐색
        for(int i = 1; i <= n; i++) {
           if(dest[i] >= max) {
               max = dest[i];
           }
        }

        // max 와 같은 값을 가진 index 탐색
        for(int i = 1; i <= n; i++) {
            if(dest[i] == max) {
                sb.append(i + " ");
            }
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    // BFS 수행
    public static void bfs(ArrayList<Integer>[] trust, boolean[] visited, int num, int[] dest) {
        Queue<Integer> queue = new LinkedList<>();

        visited[num] = true;
        queue.offer(num);

        // bfs 수행하면서 도착 하는 지점마다
        // 해당 지점에 + 1씩 더해준다
        while(!queue.isEmpty()) {
            int q = queue.poll();
            for(int i : trust[q]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
            dest[q] += 1;
        }
    }
}
