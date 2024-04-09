package com.example.coding.탐색.이진탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int array[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n - 1;
            boolean find = false;

            while(start <= end) {
                int mid = (start + end) / 2;
                if(array[mid] > target) {
                    end = mid - 1;
                } else if(array[mid] < target) {
                    start = mid + 1;
                } else {
                    find = true;
                }
                if(find == true) {
                    sb.append("1\n");
                    break;
                }
            }
            if(find == false) {
                sb.append("0\n");
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
