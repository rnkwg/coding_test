package com.example.coding.doIt.자료구조;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b_2164_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while(queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        bw.write(queue.peek() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
