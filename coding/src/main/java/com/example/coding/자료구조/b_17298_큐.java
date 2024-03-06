package com.example.coding.자료구조;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_17298_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] ngeArray = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);
        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && array[stack.peek()] < array[i]) {// 스택이 비지 않고 오큰수이면
                ngeArray[stack.pop()] = array[i];   //스택에 해당 인덱스 배열들에는 오큰수값 넣어주기
            }
            stack.push(i);  //오큰수를 만날때까지 인덱스 스택에 넣기
        }

        while(!stack.isEmpty()) //오큰수 못만난 인덱스들에는 -1 넣어주기
            ngeArray[stack.pop()] = -1;

        for(int i = 0; i < n; i++)
            bw.write(ngeArray[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
