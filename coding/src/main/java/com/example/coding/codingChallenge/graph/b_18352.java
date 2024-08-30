package com.example.coding.codingChallenge.graph;

import java.io.*;
import java.util.*;

public class b_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] road = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> answer = new ArrayList<>();
        int[] distance = new int[n + 1];

        // 인접리스트 선언
        for(int i = 0; i <= n; i++) {
            road[i] = new ArrayList<>();
        }

        // 도로 정보 입력받기
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road[a].add(b);
        }

        // bfs 탐색
        bfs(x, road, distance, visited);

        // 거리가 k인 도시 찾기
        for(int i = 0; i < n + 1; i++) {
            if(distance[i] == k)
                answer.add(i);
        }

        if(answer.size() == 0) {
            bw.write("-1\n");
        } else {
            // 오름차순 정렬
            Collections.sort(answer);
            for (int i : answer) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, ArrayList<Integer>[] road, int[] distance, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        distance[x] = 0;   // 출발지점의 거리는 0으로 초기화
        visited[x] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();

            // 인접한 도로 탐색
            for (int i : road[q]) {
                // 아직 방문하지 않은 경우
                if(!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    distance[i] = distance[q] + 1;  // 출발도시에서 + 1 거리
                }
            }
        }
    }
}
