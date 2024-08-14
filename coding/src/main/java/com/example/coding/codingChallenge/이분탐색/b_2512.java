package com.example.coding.codingChallenge.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] numArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        long m = Integer.parseInt(br.readLine());

        // 이분탐색을 위해서 numArray 배열 오름차순 정렬
        Arrays.sort(numArray);

        // 이분탐색
        int start = 1;
        int end = numArray[n - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            if(checkSum(numArray, mid, m)) {
                start = mid + 1;
            } else if (!checkSum(numArray, mid, m)) {
                end = mid - 1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(numArray[i] > end)
                numArray[i] = end;
        }

        bw.write(numArray[numArray.length - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 배정된 예산의 합이 국가 예산의 총액보다 이하인지 확인
    public static boolean checkSum(int[] numArray, int mid, long sum) {
        long tempSum = 0;
        for(int i = 0; i < numArray.length; i++) {
            if(numArray[i] > mid)
                tempSum += mid;
            else
                tempSum += numArray[i];
        }
        if(tempSum <= sum)
            return true;
        else
            return false;
    }
}
