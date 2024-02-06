package com.example.coding.자료구조;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int count = 0;

        for(int i = 0; i < n; i++) {
            int sum;
            int start = 0;
            int end = n - 1;
            int target = array[i];

            while (start < end) {
                sum = array[end] + array[start];
                if (sum == target) {
//                    더하는 수는 자기 자신을 제외해야 한다
                    if(start != i && end != i) {
                        count++;
                        break;
                    } else if(start == i) {
//                        왼쪽 포인터가 자기 자신이면 왼쪽으로 범위 좁히기
                        start++;
                    } else if(end == i) {
//                        오른쪽 포인터가 자기 자신이면 오른쪽으로 범위 좁히기
                        end--;
                    }
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
