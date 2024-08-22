package com.example.coding.codingChallenge.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b_14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[][] tree = new int[n][2];

        // 첫날 올라갔을 때 나무 길이
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++)
            tree[i][0] = Integer.parseInt(st.nextToken());

        // 나무들이 자라는 길이
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++)
            tree[i][1] = Integer.parseInt(st.nextToken());

        // 자라나는 속도가 느린 나무 기준 오름차순 정렬
        Arrays.sort(tree, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 그리디
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum +=  tree[i][0] + (long) tree[i][1] * i;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
