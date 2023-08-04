package com.example.coding.baekjoon.step2;

import java.io.*;
import java.util.StringTokenizer;

public class b_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());

        if(num1 == num2 && num2 == num3) {
            bw.write((10000 + num1 * 1000) + "");
        } else if(num1 == num2 && num2 != num3) {
            bw.write((1000 + num1 * 100) + "");
        } else if (num1 == num3 && num1 != num2) {
            bw.write((1000 + num1 * 100) + "");
        } else if (num2 == num3 && num2 != num1) {
            bw.write((1000 + num2 * 100) + "");
        } else {
            int max;
            if(num1 > num2) {
                max = num1;
            } else {
                max = num2;
            }
            if(max < num3) {
                max = num3;
            }
            bw.write((max * 100) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
