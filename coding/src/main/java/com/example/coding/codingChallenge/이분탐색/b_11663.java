package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_11663 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] spot = new int[n];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            spot[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색을 위해서 spot 배열 오름차순 정렬
        Arrays.sort(spot);

        // 선분을 입력받고 바로 이분탐색을 진행
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int startLine = Integer.parseInt(st.nextToken());
            int endLine = Integer.parseInt(st.nextToken());
            bw.write(getUpperBound(endLine, spot) - getLowerBound(startLine, spot) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 어떤 값보다 크거나 같은 원소가 나오는 첫번째 위치
    public static int getLowerBound(int x, int[] spot) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(x > spot[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    // 어떤 값보다 큰 원소가 나오는 첫번째 위치
    public static int getUpperBound(int x, int[] spot) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(x < spot[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
