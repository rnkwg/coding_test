package com.example.coding.codingChallenge.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class b_1182 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] inputArray = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        combination(inputArray, 0, 0, s, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(int[] array, int index, int partSum, int target, int count) {
        // 종료 조건
        if(index == array.length) {
            if(partSum == target && count > 0)
                answer++;
            return;
        }

        combination(array, index + 1, partSum + array[index], target, count + 1);
        combination(array, index + 1, partSum, target, count);
    }
}
