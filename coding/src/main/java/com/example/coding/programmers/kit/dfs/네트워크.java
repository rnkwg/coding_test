package com.example.coding.programmers.kit.dfs;

public class 네트워크 {
    static int count = 0;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                System.out.println("count " + count);
                dfs(i, n, computers, visited);
            }
        }

        answer = count;
        return answer;
    }

    private static void dfs(int v, int n, int[][] computers, boolean visited[]) {
        if(visited[v]) {
            return;
        }

        System.out.println("v " + v);
        visited[v] = true;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && computers[v][i] == 1 && v != i) {
                System.out.println("v " + v + " i " + i + " computers[v][i] " + computers[v][i]);
                dfs(i, n, computers, visited);
            }
        }
    }
}
