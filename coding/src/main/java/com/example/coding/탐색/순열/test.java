package com.example.coding.탐색.순열;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3};
        int r = 2;
        permutation(array, new int[r], new boolean[array.length], 0, r);
    }

    public static void permutation(int[] array, int[] out, boolean[] visited, int depth, int r) {
        if(depth == r) {
            for(int i = 0; i < out.length; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = array[i];
                permutation(array, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
}
