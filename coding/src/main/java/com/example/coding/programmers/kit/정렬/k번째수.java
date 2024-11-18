package com.example.coding.programmers.kit.정렬;
import java.util.Arrays;
public class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        // System.out.println(commands.length);
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            System.out.println("start : " + start + " end : " + end + " k : " + k);
            int[] temp = new int[end - start + 1];
            System.out.println("temp : " + temp.length);

            // start : 2 end : 5 k : 3
            // start : 4 end : 4 k : 1
            // start : 1 end : 7 k : 3

            for(int j = 0; j < temp.length; j++) {
                temp[j] = array[start + j - 1];
            }
            Arrays.sort(temp);

            answer[i] = temp[k - 1];
        }

        return answer;
    }
}
