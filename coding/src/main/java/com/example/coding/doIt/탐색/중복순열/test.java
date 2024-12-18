package com.example.coding.doIt.탐색.중복순열;

import java.io.IOException;

public class test {
    // 순열 코드에서 visited 관련 제외

    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3};
        int r = 2;
        permutation(array, new int[r], 0, r);
    }

    public static void permutation(int[] array, int[] out, int depth, int r) {
        if(depth == r) {
            for(int i = 0; i < out.length; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < array.length; i++) {
            out[depth] = array[i];
            permutation(array, out, depth + 1, r);
        }
    }
}
