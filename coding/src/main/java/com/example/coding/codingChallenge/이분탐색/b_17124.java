package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class b_17124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            int[] c = new int[n];

            StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st1.nextToken());
            }

            StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st2.nextToken());
            }

            // 이분탐색을 위해서 b배열 오름차순 정렬
            Arrays.sort(b);

            // 이분탐색
            for(int j = 0; j < n; j++) {
                int start = 0;
                int end = m - 1;
                boolean find = false;
                while (start + 1 < end) {
                    int mid = (start + end) / 2;
                    if(b[mid] > a[j]) {
                        end = mid;
                    } else if (b[mid] < a[j]) {
                        start = mid;
                    } else {
                        c[j] = b[mid];
                        find = true;
                        break;
                    }
                }

                if(!find) {
                    // 차이의 절댓값이 같은 경우 작은 수를 c에 넣어줘야함
                    if(Math.abs(a[j] - b[start]) == Math.abs(a[j] - b[end]))
                        c[j] = b[start];
                    else if(Math.abs(a[j] - b[start]) < Math.abs(a[j] - b[end]))
                        c[j] = b[start];
                    else
                        c[j] = b[end];
                }
            }

            // c 배열의 합 출력
            long answer = 0;
            for(int j = 0; j < n; j++) {
                answer += c[j];
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
