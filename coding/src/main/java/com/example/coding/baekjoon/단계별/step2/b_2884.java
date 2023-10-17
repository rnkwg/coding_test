package com.example.coding.baekjoon.단계별.step2;

import java.io.*;
import java.util.StringTokenizer;

public class b_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int hour = 0, minute = 0, resultH = 0, resultM = 0;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        hour = Integer.parseInt(st.nextToken());
        minute = Integer.parseInt(st.nextToken());

        if(minute >= 45) {
            resultM = minute - 45;
            resultH = hour;
        } else {
            resultH = hour - 1;
            resultM = minute - 45 + 60;
            if(resultH < 0) {
                resultH = 23;
            }
        }

        bw.write(resultH + " " + resultM);
        bw.flush();
        bw.close();
        br.close();
    }
}
