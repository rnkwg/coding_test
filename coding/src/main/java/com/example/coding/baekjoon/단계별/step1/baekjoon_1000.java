package com.example.coding.baekjoon.단계별.step1;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(A + B + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

//        Scanner sc = new Scanner(System.in);
//        int num1 = sc.nextInt();
//        int num2 = sc.nextInt();
//        System.out.println(num1 + num2);
    }
}
