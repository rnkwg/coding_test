package com.example.coding.codingChallenge.구현;

import java.io.*;
import java.util.StringTokenizer;

public class b_2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int[] array = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < 4; i++)
            array[i] = Integer.parseInt(st.nextToken());

        // 입력받은 숫자로 시계수 구하기
        int num = getClockNum(array);

        int sum = 0;
        for(int i = 1111; i <= num; i++)
            if(isClockNum(i))
                sum += 1;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isClockNum(int num) {
        String numString = String.valueOf(num);
        int a = numString.charAt(0) - 48;
        int b = numString.charAt(1) - 48;
        int c = numString.charAt(2) - 48;
        int d = numString.charAt(3) - 48;

        // 입력받은 숫자의 시계수 찾기
        int[] clockArray = new int[4];
        clockArray[0] = a;
        clockArray[1] = b;
        clockArray[2] = c;
        clockArray[3] = d;
        int clockNum = getClockNum(clockArray);

        // 0을 포함하는 숫자는 시계수가 될 수 없음
        if(a == 0 || b == 0 || c == 0 || d == 0)
            return false;
        else if(num == clockNum)
            return true;
        return false;
    }

    // 시계수를 반환하는 함수
    // 입력받은 배열에서 돌아가면서 시계수를 구한다
    public static int getClockNum(int[] array) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            int rotateNum = array[i] * 1000 + array[(i + 1) % 4] * 100
                    + array[(i + 2) % 4] * 10 +  array[(i + 3) % 4];
            min = Math.min(rotateNum, min);
        }
        return min;
    }
}
