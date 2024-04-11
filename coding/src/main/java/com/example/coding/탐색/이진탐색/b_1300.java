package com.example.coding.탐색.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int graph[][] = new int[n][n];
        int array[] = new int[n * n];

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++)
//                graph[i][j] = (i + 1) * (j + 1);
//        }
//
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++)
//                array[i * n + j] = graph[i][j];
//        }
//        Arrays.sort(array);

        int target = k;
        int start = 0;
        int end = n * n - 1;
        boolean find = false;
        int mid = 0;

            while(start <= end) {
                mid = (start + end) / 2;
                if(array[mid] > target) {
                    end = mid - 1;
                } else if(array[mid] < target) {
                    start = mid + 1;
                } else {
                    find = true;
                }
                if(find == true) {
                    break;
                }
            }

        bw.write(array[k - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
