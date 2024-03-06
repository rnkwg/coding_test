package com.example.coding.자료구조;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b_11286_우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            // 절대값이 큰 값에 우선순위를 부여
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                } else if (Math.abs(o1) == Math.abs(o2) ) {
                    return o1 - o2;
                } else return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if(m == 0) {
                // 큐가 비었다면 add
                if(queue.isEmpty()) {
                     sb.append(0 + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else {
                queue.add(m);
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
