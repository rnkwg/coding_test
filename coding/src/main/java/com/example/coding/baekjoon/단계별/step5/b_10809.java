package com.example.coding.baekjoon.단계별.step5;

import java.io.*;

public class b_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String s = br.readLine();

        int alp[] = new int[26];
        for(int i = 0; i < alp.length; i++) {
            alp[i] = -1;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(alp[c - 'a'] == -1) {
                alp[c - 'a'] = i;
            }
        }

        for(int i = 0; i < alp.length; i++) {
            bw.write(alp[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
