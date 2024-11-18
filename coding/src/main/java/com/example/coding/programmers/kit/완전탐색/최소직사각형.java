package com.example.coding.programmers.kit.완전탐색;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX = -1;
        int maxY = -1;

        for(int i = 0; i < sizes.length; i++) {
            if(maxX < sizes[i][0])
                maxX = sizes[i][0];
        }
        System.out.println("첫번째 : " + maxX);

        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;

                if(sizes[i][0] > maxX)
                    maxX = sizes[i][0];
            }
        }

        for(int i = 0; i < sizes.length; i++) {
            if(maxY < sizes[i][1])
                maxY = sizes[i][1];
        }

        answer = maxX * maxY;
        return answer;
    }
}
