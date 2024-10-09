package com.example.coding.codingChallenge.dp;

import java.io.*;
import java.util.*;

public class b_25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(bfs(a, k) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int a, int k) {
        boolean[] visited = new boolean[k + 1];
        Queue<int[]> queue = new LinkedList<>();

        visited[a] = true;
        queue.offer(new int[]{a, 0});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int qIndex = q[0];
            int qCount = q[1];

            // b번 징검다리로 이동한 경우 return
            if (qIndex == k) {
                return qCount;
            }

            // 1을 더하는 연산
            if(qIndex + 1 <= k) {
                if(!visited[qIndex + 1]) {
                    visited[qIndex + 1] = true;
                    queue.offer(new int[]{qIndex + 1, qCount + 1});
                }
            }

            // 2를 곱하는 연산
            if(qIndex * 2 <= k) {
                if(!visited[qIndex * 2]) {
                    visited[qIndex * 2] = true;
                    queue.offer(new int[]{qIndex * 2, qCount + 1});
                }
            }
        }

        return -1;
    }
}
