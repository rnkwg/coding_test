package com.example.coding.codingChallenge.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class b_2503 {
    static ArrayList<Integer> candidate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 후보에 숫자들을 미리 넣어둔다
        candidate = new ArrayList<>();
        for(int i = 123; i <= 987; i++) {
            String number = String.valueOf(i);
            if(!number.contains("0")) { // 0을 포함하지 않고 중복된 숫자가 없어야 후보 가능
                char number1 = number.charAt(0);
                char number2 = number.charAt(1);
                char number3 = number.charAt(2);
                if(number1 != number2 && number2 != number3 && number3 != number1) {
                    candidate.add(i);
                }
            }
        }

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            search(String.valueOf(num), strike, ball);
        }

        bw.write(candidate.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void search(String compareNum, int strike, int ball) {
        Iterator<Integer> it = candidate.iterator();
        while (it.hasNext()) {
            int compareStrike = 0;
            int compareBall = 0;
            String number = String.valueOf(it.next());
            // 후보수와 입력받은 수가 자리도 같은데 숫자도 동일하면
            // compareStrike + 1
            for(int j = 0; j < 3; j++) {
                if(number.charAt(j) == compareNum.charAt(j))
                    compareStrike++;
            }
            // 후보수와 입력받은 수가 자리는 다르지만 숫자가 동일하면
            // compareBall + 1
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k && number.charAt(j) == compareNum.charAt(k)) {
                        compareBall++;
                    }
                }
            }
            // 스트라이크, 볼 둘중에 하나라도 일치하지 않으면 후보에서 제외
            if(strike != compareStrike || ball != compareBall) {
               it.remove();
            }
        }
    }
}
