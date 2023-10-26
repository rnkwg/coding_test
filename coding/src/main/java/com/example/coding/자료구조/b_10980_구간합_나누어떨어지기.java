package com.example.coding.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_10980_구간합_나누어떨어지기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        int[] sum = new int[n];
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = array[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + array[i];
        }

        /**
         * 입력
         * 5 3
         * 1 2 3 1 2
         *
         * 1 3 6 7 9
         *
         * 출력
         * 7
         */

        for(int i = 0; i < m; i++) {
            for(int j = i; j < m; j++) {
//                if (i > 0) {
//                    if (sum[j] - sum[i - 1] % n == 0)
//                        count++;
//                } else {
//                    if(sum[j - 1] % m == 0)
//                        count++;
//                }
                if(i == j) {
                    if(array[i] % m == 0)
                        count++;
                } else if(i > 0) {
                    if(sum[j] - sum[i - 1] % n == 0)
                        count++;
                } else {
                    if(sum[j] % n == 0)
                        count++;
                }
            }
        }

//        for(int i = 0; i < m; i++) {
            bw.write(count + "\n");
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}
