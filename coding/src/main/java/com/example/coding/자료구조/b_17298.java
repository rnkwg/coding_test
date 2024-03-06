package com.example.coding.자료구조;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        /**
         * 입력
         * 4
         * 3 5 2 7
         *
         * 출력
         * 5 7 7 -1
         */

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] ngeArray = new int[n];
        int nge = 0;
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            ngeArray[i] = 0;
        }

        stack.push(0);
        for(int i = 1; i < n; i++) {
            if(array[i] < array[i - 1])
                stack.push(array[i]);
            else {
                nge = array[i];
                ngeArray[i - 1] = array[i];
            }
        }
        ngeArray[n - 1] = -1;

        for(int i = 0; i < n; i++) {
            if(ngeArray[i] == 0) {
                if(array[i] >= nge)
                    ngeArray[i] = -1;
                else
                    ngeArray[i] = nge;
            }
        }
        for(int i = 0; i < n; i++)
            bw.write(ngeArray[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
