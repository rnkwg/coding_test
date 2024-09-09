package com.example.coding.codingChallenge.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1326 {
    static int jumpCount = 0;
    static boolean isJump = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] bridge = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write( bfs(a, b, bridge) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // BFS 수행
    public static int bfs(int a, int b, int[] bridge) {
        boolean[] visited = new boolean[bridge.length];
        Queue<int[]> queue = new LinkedList<>();

        visited[a] = true;
        queue.offer(new int[] {a, 0});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int qIndex = q[0];
            int qJump = q[1];

            // b번 징검다리로 이동한 경우 return
            if(qIndex == b) {
                return qJump;
            }

                // 점프 가능한 위치로 이동한다 (오른쪽)
                for (int i = qIndex + bridge[qIndex]; i < bridge.length; i += bridge[qIndex]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.offer(new int[]{i, qJump + 1});
                    }
                }

                // 점프 가능한 위치로 이동한다 (왼쪽)
                for (int i = qIndex - bridge[qIndex]; i > 0; i -= bridge[qIndex]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.offer(new int[]{i, qJump + 1});
                    }
                }
        }

        return -1;
    }
}
