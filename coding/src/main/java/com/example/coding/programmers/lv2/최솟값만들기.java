package com.example.coding.programmers.lv2;
import java.util.*;
public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        // 곱의 누적합이 최소가 되기 위해서는
        // A 배열은 오름차순 정렬, B 배열은 내림차순 정렬
        Arrays.sort(A);
        reverseSort(B);

        int answer = 0;
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }

    // 내림차순 정렬
    public static void reverseSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
