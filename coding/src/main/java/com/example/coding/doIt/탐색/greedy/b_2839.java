package com.example.coding.doIt.탐색.greedy;

import java.io.*;

public class b_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int suger = Integer.parseInt(br.readLine());
        int sum = 0;

        // 5로 나누어 떨어진다
        // 3으로 나누어 떨어진다
        // 둘다 나누어 떨어지지 않는다
        while(suger > 0) {
            if(suger % 5 == 0) {
                sum += suger / 5;
                break;
            } else {
                suger -= 3;
                sum++;
            }
            if(suger < 0) {
                sum = -1;
                break;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
