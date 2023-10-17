package com.example.coding.baekjoon.단계별.step3;

import java.io.*;
import java.util.StringTokenizer;

public class b_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String s = "";
        String str;
        while((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            s += a + b + "\n";
        }


        bw.write(s);

        bw.flush();
        bw.close();
        br.close();
    }
}
