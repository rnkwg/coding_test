package com.example.coding.탐색.조합;

import java.io.IOException;

public class test {

    //순서가 상관이 없어 (1, 2) = (2, 1)
    //(1, 2) 만을 카운팅
    //현재 선택한 워소보다 뒤에 있는 원소에 대해서만 카운팅
    //탐색의 시작 인덱스 = start
    //재귀 호출 시에는 현재 인덱스인 i + 1 = start
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3};
        int r = 2;
        combination(array, new boolean[array.length], 0, 0, r);
    }

    public static void combination(int[] array, boolean[] visited, int start, int depth, int r) {
        if(depth == r) {
            for(int i = 0; i < array.length; i++) {
                if(visited[i])
                    System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(array, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }
}
