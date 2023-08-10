package com.example.coding.baekjoon.step5;

import java.io.*;

public class b_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String answer = "";

        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            answer += s.charAt(0) + "" + s.charAt(s.length() - 1) + "\n";
        }

        bw.write(answer);

        bw.flush();
        bw.close();
        br.close();
    }
}
