package com.example.coding.codingChallenge.구현;

import java.io.*;
import java.util.StringTokenizer;

public class b_13567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;

        int dir = 1;
        boolean check = false;
        for(int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine().trim());
           String order = st.nextToken();
           int d = Integer.parseInt(st.nextToken());
           if(order.equals("TURN")) {
               if(d == 0) {
                   switch (dir) {
                       case 1 :
                           dir = 3;
                           break;
                       case 2 :
                           dir = 4;
                           break;
                       case 3 :
                           dir = 2;
                           break;
                       default:
                           dir = 1;
                           break;
                   }
               } else if(d == 1) {
                   switch (dir) {
                       case 1 :
                           dir = 4;
                           break;
                       case 2 :
                           dir = 3;
                           break;
                       case 3 :
                           dir = 1;
                           break;
                       default:
                           dir = 2;
                           break;
                   }
               }
           } else if(order.equals("MOVE")) {
               if(dir == 1) {
                   x += d;
               } else if(dir == 2){
                   x -= d;
               } else if(dir == 3) {
                   y += d;
               } else {
                   y -= d;
               }
           }

            if(x > m || y > m || x < 0 || y < 0) {
                bw.write("-1\n");
                check = true;
                break;
            }
        }

        if(!check)
            bw.write(x + " " + y);

        bw.flush();
        bw.close();
        br.close();
    }
}
