package com.example.coding.programmers.kit.완전탐색;
import java.util.*;
public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] array1 = new int[answers.length];
        int[] array2 = new int[answers.length];
        int[] array3 = new int[answers.length];
        int[] answerCount = {0, 0, 0};

        for(int i = 0; i < answers.length; i++) {
            if(i % 5 == 1) {
                array1[i] = 2;
            } else if(i % 5 == 2) {
                array1[i] = 3;
            } else if(i % 5 == 3) {
                array1[i] = 4;
            } else if(i % 5 == 4) {
                array1[i] = 5;
            } else if(i % 5 == 0) {
                array1[i] = 1;
            }

            if(i % 8 == 1) {
                array2[i] = 1;
            } else if(i % 8 == 2) {
                array2[i] = 2;
            } else if(i % 8 == 3) {
                array2[i] = 3;
            } else if(i % 8 == 4) {
                array2[i] = 2;
            } else if(i % 8 == 5) {
                array2[i] = 4;
            } else if(i % 8 == 6) {
                array2[i] = 2;
            } else if(i % 8 == 7) {
                array2[i] = 5;
            } else if(i % 8 == 0) {
                array2[i] = 2;
            }

            if(i % 10 == 1) {
                array3[i] = 3;
            } else if(i % 10 == 2) {
                array3[i] = 1;
            } else if(i % 10 == 3) {
                array3[i] = 1;
            } else if(i % 10 == 4) {
                array3[i] = 2;
            } else if(i % 10 == 5) {
                array3[i] = 2;
            } else if(i % 10 == 6) {
                array3[i] = 4;
            } else if(i % 10 == 7) {
                array3[i] = 4;
            } else if(i % 10 == 8) {
                array3[i] = 5;
            } else if(i % 10 == 9) {
                array3[i] = 5;
            } else if(i % 10 == 0) {
                array3[i] = 3;
            }
        }

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == array1[i]) {
                answerCount[0]++;
            }
            if(answers[i] == array2[i]) {
                answerCount[1]++;
            }
            if(answers[i] == array3[i]) {
                answerCount[2]++;
            }
        }

        int max = -1;
        for(int i = 0; i < answerCount.length; i++) {
            System.out.println(answerCount[i]);
            if(max < answerCount[i]) {
                max = answerCount[i];
            }
        }

        List<Integer> answerList = new ArrayList<Integer>();
        for(int i = 0; i < answerCount.length; i++) {
            if(max == answerCount[i]) {
                answerList.add(i + 1);
            }
        }

        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
