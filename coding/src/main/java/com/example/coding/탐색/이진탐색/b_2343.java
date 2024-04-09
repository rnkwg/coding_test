package com.example.coding.탐색.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2343 {
    static int n;
    static int array[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        array = new int[n];
        int m = Integer.parseInt(st.nextToken());
        int start = 0;  //가장 큰 값
        int mid = 0;
        int end = 0;    //array 모두 더한 값

        // array 입력받기
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if(start < array[i])
                start = array[i];
            end += array[i];
        }

        while(start <= end) {
            mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for(int i = 0; i < n; i++) {
                // 배열의 값을 더했을 때 mid 보다 크다면
                if(sum + array[i] > mid) {
                    // count + 1, sum 초기화
                    count += 1;
                    sum = 0;
                }
                sum += array[i];
            }

            if (sum != 0)
                count++;
            if (count > m)
                start = mid + 1;
            else
                end = mid - 1;
        }

        // 최솟값을 구해야 하기 때문에 start > end 가 되기 직전의 start 가 답
        bw.write(start + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
