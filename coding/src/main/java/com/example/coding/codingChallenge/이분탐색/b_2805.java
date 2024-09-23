package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        int [] tree = new int[n];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            tree[i] =  Integer.parseInt(st.nextToken());
        }

        // 이분 탐색 위한 나무 높이에 따른 오름차순 정렬
        Arrays.sort(tree);

        // 나무 높이 이분탐색
        long start = 0;
        long end = tree[n - 1];
        long result = -1;
        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;   // 나무를 자른 후 나머지 나무
            for(int i = 0; i < n; i++) {
                // 나머지 나무의 합
                if(mid < tree[i])
                    sum += tree[i] - mid;
            }

            if(sum < m) {
               end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}