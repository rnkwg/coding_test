package com.example.coding.codingChallenge.greedy;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b_18230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Integer[] prettyA = new Integer[A];
        Integer[] prettyB = new Integer[B];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < A; i++) {
            prettyA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < B; i++) {
            prettyB[i] = Integer.parseInt(st.nextToken());
        }

        // 예쁨이 큰 타일부터 내림차순 정렬
        Arrays.sort(prettyA, Collections.reverseOrder());
        Arrays.sort(prettyB, Collections.reverseOrder());

        // 예쁨이 큰 타일부터 넣어서
        // 바닥을 다 채운다는 조건을 만족하면 반복문 탈출
        int max = 0;    // 예쁨의 최댓값
        int spaceLeft = N;  // 남은 공간
        int indexA = 0; int indexB = 0;
        while(spaceLeft > 0) {  // 2 * 2 타일이 2 * 1 타일 2개의 예쁨보다 큰지 확인
            if (spaceLeft >= 2 && indexB < B &&
                    (indexA >= A - 1 || prettyB[indexB] >= (indexA < A ? prettyA[indexA] + (indexA + 1 < A ? prettyA[indexA + 1] : 0) : 0))) {
                max += prettyB[indexB];
                spaceLeft -= 2;
                indexB++;
            } else if (indexA < A) { // 그렇지 않으면 2 * 1 타일 사용
                max += prettyA[indexA];
                spaceLeft -= 1;
                indexA++;
            } else { // 더 이상 사용할 타일이 없으면 반복문 종료
                break;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
