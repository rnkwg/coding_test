package com.example.coding.doIt.탐색.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[length][2];

        for(int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의시간이 일찍 끝나는 순서대로 정렬
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        // 끝 시간 <= 시작시간 이면
        // count + 1, 끝 시간 다시 할당해주기
        int count = 0;
        int end = -1;
        for(int i = 0; i < length; i++) {
            if(timeTable[i][0] >= end) {
                end = timeTable[i][1];
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
