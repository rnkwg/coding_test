package com.example.coding.codingChallenge.bruteForce;

import com.sun.source.doctree.SeeTree;

import java.io.*;
import java.util.*;

public class b_2210 {
    static int answer = 0;
    static Set<String> set = new HashSet<>();

    // 상하좌우 탐색 위한 배열
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int[][] graph = new int[5][5];
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        String numbers = "";
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                move(graph, numbers, i, j, 0);

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void move(int[][] graph, String numbers, int x, int y, int depth) {
        // 종료 조건 : 6개의 정수가 선택이 완료되었을 때
        if(depth == 6) {
            set.add(numbers.toString());
            return;
        }

        numbers += (graph[x][y]);

        // 인접한 네 방향으로 이동
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 5 && ny < 5 && nx >= 0 && ny >= 0)
                move(graph, numbers, nx, ny, depth + 1);
        }
    }
}
