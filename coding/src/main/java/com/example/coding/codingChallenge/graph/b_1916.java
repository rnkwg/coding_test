package com.example.coding.codingChallenge.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_1916 {
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];  // 인접리스트로 그래프
        distance = new int[n + 1];   // 최단 거리 배열
        visited = new boolean[n + 1]; // 사용 노드인지 판별 배여
        // 인접리스트 선언
        for(int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<Node>();
        }

        Arrays.fill(distance, Integer.MAX_VALUE);   // 거리 배열 충분히 큰 수로 초기화

        // 그래프를 인접리스트로 입력받기
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(startIndex, endIndex) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue =  new PriorityQueue<>();
        // 시작 노드의 가중치와 거리는 0으로 초기화
        queue.offer(new Node(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int now = nowNode.node;
            if(!visited[now]) { // 큐에서 꺼낸 노드를 방문하지 않았으면
                visited[now] = true;    // 방문처리
                for(Node n : list[now]) {   // 해당 노드와 연결된 모든 노드 탐색
                    if(!visited[n.node] && distance[n.node] > distance[now] + n.value) {
                        // 타겟노드 방문 안함 && 타겟노드 > 선택노드 + 비용
                        distance[n.node] = distance[now] + n.value; // 거리 업데이트
                        queue.add(new Node(n.node, distance[n.node]));  // 큐에 삽입
                    }
                }
            }
        }
        return distance[end];
    }
}

class Node implements Comparable<Node> {
    int node;
    int value;

    Node(int node, int value) {
        this.node = node;
        this.value = value;
    }

    //현재 연결된 노드 중 가장 적은 비용을 가지고 있는 노드를 선택
    @Override
    public int compareTo(Node e) {
        return this.value - e.value;
    }
}