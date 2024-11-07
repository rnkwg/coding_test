package com.example.coding.doIt.자료구조;

import java.io.*;
import java.util.Stack;

public class b_1874_스택_오름차순 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1; // stack 에 들어갈 오름차순 숫자
        StringBuilder sb = new StringBuilder();
        boolean noFlag = false;

        for(int i = 0; i < array.length; i++) {
            if(num <= array[i]) {
                // 배열의 숫자가 오름차순보다 크거나 같으면 배열의 숫자까지 스택에 넣어주기
                // + 출력
                while(num <= array[i]) {
                    stack.push(num);
                    sb.append("+\n");
                    num += 1;
                }
                // 스택과 배열과 존재하는 것까지 pop
                stack.pop();
                sb.append("-\n");
            } else {
                // 스택에서 꺼낸게 배열보다 작아야 ok
                if(stack.pop() <= array[i]) {
                    sb.append("-\n");
                } else {
                    bw.write("NO");
                    noFlag = true;
                    break;
                }
            }
        }

        if(noFlag == false) {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
