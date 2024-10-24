package com.example.coding.codingChallenge.구현;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 트럭 무게 입력 받기
        // 이때도 큐를 사용한다는 것이 킥
        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++)
            truck.add(Integer.parseInt(st.nextToken()));

        int count = 0;  // 지나는 시간
        int weight = 0; // 다리의 무게 총합
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < w; i++)
           bridge.add(0);

        // 트럭이 모두 다리를 건널 때까지 반복
        while(!bridge.isEmpty()) {
            count++;    // 시간은 1씩 증가
            weight -= bridge.poll();    // 다리에 가장 앞서 있는 트럭 무게 빼기
            if(!truck.isEmpty()) {
                if(truck.peek() + weight <= l) {    // 다리에 올라가려는 트럭의 무게와 지금까지의 무게 합이 l보다 작은지
                    weight += truck.peek(); // 다리의 무게 총합에 가장 첫번째 트럭 무게 더하기
                    bridge.add(truck.poll());   // 다리에 트럭을 올린다
                } else {
                    bridge.add(0);  // 트럭을 올리지 않았으므로 0을 올리기
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
