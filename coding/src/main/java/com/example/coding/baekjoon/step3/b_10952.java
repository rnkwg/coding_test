package com.example.coding.baekjoon.step3;

import java.io.*;
import java.util.StringTokenizer;

public class b_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String s = "";
        while(true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0)
                break;
            s += a + b + "\n";
        }


        bw.write(s);

        bw.flush();
        bw.close();
        br.close();
    }
}
