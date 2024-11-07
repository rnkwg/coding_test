package com.example.coding.doIt.자료구조;

import java.io.*;
import java.util.StringTokenizer;

public class b_10986_구간합_나누어떨어지기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] array = new long[n];   //입력받는 배열
        long[] sum = new long[n]; //구간합의 나머지를 저장하는 배열
        long[] check = new long[m];   //인덱스에 나머지의 종류(0 ~ m-1)을 갖는 배열
        long count = 0;  //답 count

        //입력받기
        //입력받으면서 구간합 배열 저장하기
        st = new StringTokenizer(br.readLine(), " ");
        array[0] = Integer.parseInt(st.nextToken());
        sum[0] = array[0];
        for(int i = 1; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + array[i];
        }

        //구간합의 나머지를 배열에 다시 저장한다
        //저장하면서 만약에 나머지가 0으로 떨어지는 경우에는 바로 count + 1
        //check 배열에도 count + 1
        for(int i = 0; i < n; i++) {
            sum[i] = sum[i] % m;
            if(sum[i] == 0)
                count++;
            check[(int) sum[i]]++;
        }

        //같은 나머지를 갖는 것들 중에서 중복되지 않고 순서가 없으니
        //m = 3인 경우에는 3C2 + 2C2
        for(int i = 0; i < m; i++) {
            count += check[i] * (check[i] - 1) / 2;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
