package com.example.coding.programmers.kit.dfs;

public class 타겟넘버 {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        combination(numbers, 0, target, 0);

        return answer;
    }

    public void combination(int[] array, int r, int target, int sum) {
        if(r == array.length) {
            if(target == sum)
                answer += 1;
        } else {
            combination(array, r + 1, target, sum + array[r]);
            combination(array, r + 1, target, sum - array[r]);
        }
    }
}
