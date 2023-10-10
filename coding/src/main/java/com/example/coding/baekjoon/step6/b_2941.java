package com.example.coding.baekjoon.step6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class b_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int count;

        String[] alpha = new String[8];
        alpha[0] = "c-";
        alpha[2] = "c=";
        alpha[1] = "dz=";
        alpha[3] = "lj";
        alpha[4] = "nj";
        alpha[5] = "s=";
        alpha[6] = "z=";
        alpha[7] = "d-";

        String s = br.readLine();
        for(int i = 0; i < 8; i++) {
            if(s.contains(alpha[i])) {
                s = s.replace(alpha[i], "!");
            }
        }

        count = s.length();

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
