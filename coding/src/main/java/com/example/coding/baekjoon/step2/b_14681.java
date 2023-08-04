package com.example.coding.baekjoon.step2;

import java.io.*;

public class b_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        if(num1 > 0 && num2 > 0) {
            bw.write("1\n");
        } else if(num1 < 0 && num2 > 0) {
            bw.write("2");
        } else if(num1 < 0 && num2 <0) {
            bw.write("3");
        } else {
            bw.write("4");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
