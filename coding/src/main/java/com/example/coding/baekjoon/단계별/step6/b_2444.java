package com.example.coding.baekjoon.단계별.step6;

import java.io.*;

public class b_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = n - i; j >= 1; j--)
                bw.write(" ");
            for(int k = 1; k <= i * 2 - 1; k++)
                bw.write("*");
            bw.write("\n");
        }

        for(int i = 1; i <= n - 1; i++) {
            for(int j = 1; j <= i; j++)
                bw.write(" ");
            for(int k = 1; k <= n * 2 - (i * 2 + 1); k++)
                bw.write("*");
            bw.write("\n");
        }

        /**
         *  입력 : 5
         *  결과 : 7 5 3 1 이 나와야 함
         *  가공은 1 2 3 4
         *  더하면 6 7 8 9
         *  뻬면  4 3 2 1
         *  두배 하면 2 4 6 8
         *  가공을 4 3 2 1
         *  3 5 7 9
         *  1 3 5 7 9
         *  10 에서 3 5 7 9  빼는 방햐응로
         * */
        bw.flush();
        bw.close();
        br.close();
    }
}
