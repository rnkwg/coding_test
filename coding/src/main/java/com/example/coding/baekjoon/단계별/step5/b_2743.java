package com.example.coding.baekjoon.단계별.step5;

import java.io.*;
import java.util.StringTokenizer;

public class b_2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String[] strArr = br.readLine().split("");

        int count = 0;
        for(int i = 0; i < strArr.length; i++) {
            switch (strArr[i]) {
                case "A" : case "B": case "C" :
                    count += 3;
                    break;

                case "D" : case "E": case "F" :
                    count += 4;
                    break;

                case "G" : case "H": case "I" :
                    count += 5;
                    break;

                case "J" : case "K": case "L" :
                    count += 6;
                    break;

                case "M" : case "N": case "O" :
                    count += 7;
                    break;

                case "P" : case "Q": case "R" : case "S" :
                    count += 8;
                    break;

                case "T" : case "U": case "V" :
                    count += 9;
                    break;

                case "W" : case "X": case "Y" : case "Z" :
                    count += 10;
                    break;
            }
        }


        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
