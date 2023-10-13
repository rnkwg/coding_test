package com.example.coding.baekjoon.step6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        HashMap<String, Double> score = new HashMap<String, Double>();
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F", 0.0);
        score.put("P", 4.5);

        double gradeTotal = 0;
        double scoreTotal = 0;

        //ObjectOrientedProgramming1 3.0 A+

        for(int i = 0; i < 20; i++) {
            String st = br.readLine();
            StringTokenizer str = new StringTokenizer(st);
            str.nextToken();
            double grade = Double.parseDouble(str.nextToken());
            gradeTotal += grade;
            String scoreToken = str.nextToken();
            if(scoreToken.equals("P"))  {
                gradeTotal -= grade;
                continue;
            }
            scoreTotal += score.get(scoreToken) * grade;
        }

        /**
         * 값을 먼저 읽고
         * strngtokenizer로 값 분리하기
         *
         */
        bw.write(scoreTotal / gradeTotal + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
