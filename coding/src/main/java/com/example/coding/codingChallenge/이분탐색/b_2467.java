package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] numArray = new int[n];
        ArrayList<Integer> sumArray = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색을 위해서 numArray 배열 오름차순 정렬
        Arrays.sort(numArray);

        // 이분탐색
        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        int answerStart = -1;
        int answerEnd = -1;
        while (start < end) {
            int sum = numArray[start] + numArray[end];
            if(Math.abs(min) > Math.abs(sum)) {
                min = sum;
                answerStart = start;
                answerEnd = end;
            }

            if(sum > 0) {
                end--;
            } else {
                start++;
            }
        }


        bw.write(numArray[answerStart] + " " + numArray[answerEnd]);
        bw.flush();
        bw.close();
        br.close();
    }
}
