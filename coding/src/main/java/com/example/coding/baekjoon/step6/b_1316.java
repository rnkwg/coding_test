package com.example.coding.baekjoon.step6;

import java.io.*;

public class b_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        int count = n;
        Integer[] alpha = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0};

        for(int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        /**
         * aba
         * abab
         * abcabc
         * a
         * -> 1
         *
         * 한번 등장했을 때 0 -> 1로 변경
         * 0이면 그냥 + 1
         * 1이면 바로 이전꺼 검사해서 같으면 넘어가고 다르면 문제 있는거
         */
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < s[i].length(); j++) {
                if(alpha[ s[i].charAt(j) - 'a' ] == 0)
                    alpha[ s[i].charAt(j) - 'a' ] = 1;
                else {
                    if(s[i].charAt(j) != s[i].charAt(j - 1)) {
                        count--;
                        break;
                    }
                }
            }
            alpha = new Integer[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0};
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
