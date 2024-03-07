package com.example.coding.자료구조;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_2023 {
    static int count = 1;
    static int n;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        result = new ArrayList<Integer>();

        for(int i = 2; i <= 9; i++) {
            if(isPrime(i)) {
                dfs(i);
            }
        }

        for(int i = 0; i < result.size(); i++) {
            bw.write("result " + i + result.get(i) + "\n");
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

    static void dfs(int v) {
        if(!isPrime(v)) {
            return;
        } else if(count == n) {
            System.out.println("!!" + v);
            result.add(v);
        }

        count++;
        if(count <= n) {
            for(int i = 1; i <= 9; i++) {
                int m = v * 10 + i;
                System.out.println(m);
                if(isPrime(m))
                    dfs(m);
            }
        }
    }
}
