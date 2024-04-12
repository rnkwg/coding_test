package com.example.coding.탐색.greedy;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        String str[] = br.readLine().split("-");
        for(int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0)
                answer = answer + temp; // 제일 앞에 것만 더해주고
            else
                answer = answer - temp; // 뒤에 부분은 더한 값들을 빼줌
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int mySum(String str) {
        int sum = 0;
        String temp[] = str.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
