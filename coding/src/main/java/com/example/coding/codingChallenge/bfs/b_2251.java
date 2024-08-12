package com.example.coding.codingChallenge.bfs;

import java.io.*;
import java.util.*;

public class b_2251 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bfs(A, B, C, new boolean[201][201][201]);

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int A, int B, int C, boolean[][][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        // 처음에는 C 만큼의 물만 존재
        queue.offer(new int[] {0, 0, C});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int qA = q[0];
            int qB = q[1];
            int qC = q[2];

            if(!visited[qA][qB][qC]) {
                // a, b, c 의 순열 방문처리
                visited[qA][qB][qC] = true;

                // a 물통에 들어있는 물의 양이 0일때 c 물통에 들어있는 물의 양 add
                if(qA == 0)
                    list.add(qC);

                // 1. a -> b
                if(qA + qB >= B) {  // 물이 넘치는 경우
                    queue.add(new int[] {qA - (B - qB), B, qC});
                } else {    // 물이 넘치지 않는 경우
                    queue.add(new int[] {0, qA + qB, qC});
                }
                // 2. a -> c
                if(qA + qC >= C) {  // 물이 넘치는 경우
                    queue.add(new int[] {qA - (C - qC), qB, C});
                } else {    // 물이 넘치지 않는 경우
                    queue.add(new int[] {0, qB, qA + qC});
                }
                // 3. b -> a
                if(qA + qB >= A) {  // 물이 넘치는 경우
                    queue.add(new int[] {A, qB - (A - qA), qC});
                } else {    // 물이 넘치지 않는 경우
                    queue.add(new int[] {qA + qB, 0, qC});
                }
                // 4. b -> c
                if(qB + qC >= C) {  // 물이 넘치는 경우
                    queue.add(new int[] {qA, qB - (C - qC), C});
                } else {    // 물이 넘치지 않는 경우
                    queue.add(new int[] {qA, 0, qB + qC});
                }
                // 5. c -> a
                if(qA + qC >= A) {  // 물이 넘치는 경우
                    queue.add(new int[] {A, qB, qC - (A - qA)});
                } else {    // 물이 넘치지 않는 경우
                    queue.add(new int[] {qA + qC, qB, 0});
                }
                // 6. c -> b
                if(qB + qC >= B) {  // 물이 넘치는 경우
                    queue.add(new int[] {qA, B, qC - (B - qB)});
                } else {    // 물이 넘치지 않는 경우
                    queue.add(new int[] {qA, qB + qC, 0});
                }
            }
        }
    }
}
