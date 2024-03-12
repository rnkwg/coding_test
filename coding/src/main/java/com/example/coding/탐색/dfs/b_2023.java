package com.example.coding.탐색.dfs;

import java.io.*;
import java.util.ArrayList;

public class b_2023 {
    static int n;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        result = new ArrayList<Integer>();

        // 제일 마지막 자리의 경우 소수가 되는 경우는 : 2, 3, 5, 7
        // 자릿수를 같이 param 으로 보낸다
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        for(int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    static void dfs(int v, int jarisu) {
        // 자릿수 = n && 소수라면 결과 배열에 add
        // 자릿수 = n && !소수라면 return
        if(jarisu == n) {
            if(isPrime(v)) {
                result.add(v);
            }
            return;
        }

        for(int i = 1; i <= 9; i++) {
            // 마지막 자리 짝수의 경우는 소수가 아님
            if(i % 2 == 0) continue;

            // 자리 늘려가기
            if(isPrime(v * 10 + i)) {
                dfs(v * 10 + i, jarisu + 1);
            }
        }

    }
}
