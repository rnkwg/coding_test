package com.example.coding.탐색.중복조합;

import java.io.IOException;

public class test {
    // 중복이 가능하기 때문에 visited 관련 배열 제거
    // start 가 현재 선택한 것의 포함으로 선택 가능하기 때문에 i
    // 조합과 다르게 중복이 가능하기 때문에 선택한 원소 저장하는 out 배열이 필요
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3};
        int r = 2;
        combination(array, new int[r], 0, 0, r);
    }

    public static void combination(int[] array, int[] out, int start, int depth, int r) {
        if(depth == r) {
            for(int i = 0; i < out.length; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < array.length; i++) {
            out[depth] = array[i];
            combination(array, out, i, depth + 1, r);
        }
    }
}
