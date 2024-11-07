package com.example.coding.doIt.탐색.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < length; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(queue.size() != 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            sum += (num1) + (num2);
            queue.add(num1 + num2);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
