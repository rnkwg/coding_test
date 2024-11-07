package com.example.coding.doIt.탐색.greedy;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class b_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < length; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();

            // (+, +)
            // (+, 0)
            // (0, 0)
            // (0, -)
            // (-, -)
            if(num1 > 0 && num2 > 0) {
                if(num1 * num2 > num1 + num2) {
                    sum += (num1) * (num2);
                } else {
                    sum += (num1) + (num2);
                }
            } else if(num1 > 0 && num2 == 0) {
                if(num1 * num2 > num1 + num2) {
                    sum += (num1) * (num2);
                } else {
                    sum += (num1) + (num2);
                }
            } else if(num1 == 0 && num2 == 0) {
                sum += (num1) * (num2);
            } else if(num1 == 0 && num2 < 0){
                if(num1 * num2 > num1 + num2) {
                    sum += (num1) * (num2);
                } else {
                    sum += (num1) + (num2);
                }
            } else if(num1 < 0 && num2 < 0) {
                if(num1 * num2 > num1 + num2) {
                    sum += (num1) * (num2);
                } else {
                    sum += (num1) + (num2);
                }
            }
        }

        if(!queue.isEmpty())
            sum += queue.poll();

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
