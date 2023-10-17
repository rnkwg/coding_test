package com.example.coding.baekjoon.단계별.step6;

import java.io.*;

public class b_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String[] s = br.readLine().split("");
        boolean flag = true;

        for(int i = 0; i < s.length / 2; i++) {
            if(!s[i].equals(s[s.length - i - 1])) {
                bw.write("0");
                flag = false;
                break;
            }
        }

        if(flag)
            bw.write("1");

        bw.flush();
        bw.close();
        br.close();
    }
}
