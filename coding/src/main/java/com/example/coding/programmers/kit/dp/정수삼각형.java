package com.example.coding.programmers.kit.dp;
import java.util.*;
public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {    // 왼쪽 끝
                    triangle[i][j] += triangle[i - 1][0];   // 윗줄의 왼쪽 끝만을 더함
                } else if(j == triangle[i].length - 1) {    // 오른쪽 끝
                    // 윗줄의 오른쪽 끝만을 더한다
                    triangle[i][j] += triangle[i - 1][triangle[i - 1].length - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
            }
        }

        for(int i = 0; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                answer = Math.max(triangle[i][j], answer);
            }
        }

        return answer;
    }
}
