package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] loc = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < m; i++)
            loc[i] = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = n;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            boolean check = canCoverBridge(loc, mid, n);
            if(check) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean canCoverBridge(int[] lamps, int height, int bridgeLength) {
        int lastCovered = 0;  // 마지막으로 커버된 위치

        for (int lamp : lamps) {
            // 이번 가로등의 왼쪽 끝이 마지막 커버된 위치보다 멀면 다 커버하지 못함
            if (lamp - height > lastCovered) {
                return false;
            }

            // 현재 가로등이 커버할 수 있는 범위 업데이트
            lastCovered = lamp + height;

            // 다리 끝을 넘겼다면 다 커버한 것
            if (lastCovered >= bridgeLength) {
                return true;
            }
        }

        // 마지막 가로등까지 커버를 다 못한 경우
        return lastCovered >= bridgeLength;
    }
}
