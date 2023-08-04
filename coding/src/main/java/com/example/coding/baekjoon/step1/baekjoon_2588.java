package com.example.coding.baekjoon.step1;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int num2 = Integer.parseInt(str);

        char strArray[] = str.toCharArray();

        for (int i = strArray.length - 1; i >= 0; i--) {
            bw.write(
                    Integer.parseInt(String.valueOf(strArray[i])) * num1 +
                    "\n");

        }
        bw.write(num1 * num2 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
