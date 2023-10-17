package com.example.coding.baekjoon.단계별.step2;

import java.io.*;
import java.util.StringTokenizer;

public class b_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

//        int T = Integer.parseInt(br.readLine());
        int hour = 0, minute = 0, resultH = 0, resultM = 0;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        hour = Integer.parseInt(st.nextToken());
        minute = Integer.parseInt(st.nextToken());

        int add = Integer.parseInt(br.readLine());

        resultM = minute + add;
        if(resultM >= 60) {
            resultH = hour + (resultM / 60);
            resultM = resultM  % 60;
        } else {
            resultH = hour;
        }

        if(resultH >= 24) {
            resultH = resultH - 24;
        }

        bw.write(resultH + " " + resultM + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
