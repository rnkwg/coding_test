package com.example.coding.자료구조;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        //배열크기 입력받기
        int arraySize = Integer.parseInt(br.readLine());
        int[] array = new int[arraySize];

        //목표 합 입력받기
        int n = Integer.parseInt(br.readLine());

        //배열 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int count = 0;
        int start = 0;
        int end = arraySize - 1;

        while(start < end) {
            if(array[start] + array[end] == n) {
                count++;
                start++;
                end--;
            } else if(array[start] + array[end] > n) {
                end--;
            } else if(array[start] + array[end] < n) {
                start++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
