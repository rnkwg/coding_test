package com.example.coding.codingChallenge.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class b_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] array = new char[n];
        boolean[] visited = new boolean[n];   // 이미 먹은 햄버거인지 확인하는 배열
        array = br.readLine().toCharArray();
        int count = 0;

        // 그리디
        for(int i = 0; i < n; i++) {
            if(array[i] == 'P') {
                int start = Math.max(i - k, 0);
                int end = Math.min(i + k, n - 1);
                for(int j = start; j <= end; j++) {
                    if(array[j] == 'H' && !visited[j]) {
                        visited[j] = true;  // 햄버거를 먹었으므로 true
                        count += 1;
                        break;
                    }
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
