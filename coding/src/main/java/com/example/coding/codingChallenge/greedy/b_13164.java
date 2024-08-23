package com.example.coding.codingChallenge.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class b_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] height = new Integer[N];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 키의 차이 배열 만들기
        Integer[] diffHeight = new Integer[N - 1];
        for(int i = 0 ; i < N - 1; i++) {
            diffHeight[i] = height[i + 1] - height[i];
        }

        // 키의 차이 배열 내림차순 정렬
        Arrays.sort(diffHeight, Collections.reverseOrder());

        // 키의 차이를 최소로 만들어야 하므로
        // 구간이 (k - 1) 개인 경우, 가장 큰 차이 : height[N - 1] - height[0]
        // 에서 (k - 1)만큼 가장 큰 차이들을 제거 가능
        int minCost = height[N - 1] - height[0];
        for(int i = 0; i < K - 1; i++)
            minCost -= diffHeight[i];

        bw.write(minCost + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
