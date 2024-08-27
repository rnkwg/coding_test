package com.example.coding.codingChallenge.시물레이션;


import java.io.*;
import java.util.*;

public class b_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> candidate = new HashMap<>();
        List<Integer> frame = new ArrayList<>();

        int studentN = Integer.parseInt(br.readLine());
        int[] student = new int[studentN];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < studentN; i++)
            student[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < studentN; i++) {
            if(candidate.containsKey(student[i])) { // 중복추천을 받은 경우
                // 추천수 + 1
                candidate.put(student[i], candidate.get(student[i]) + 1);
            } else {    // 중복추천을 받지 않은 경우
                 if(candidate.size() < n) {
                    // 빈 자리가 있는 경우
                    candidate.put(student[i], 1);
                    frame.add(student[i]);  // 액자에 등록
                } else {
                    // 추천 수가 가장 적은 학생 찾기
                    int min = 2000;
                    int minKey = -1;
                    int old = n + 1;

                    // 가장 추천 수가 적고
                    // 가장 오래전에 등록 된 학생 탐색
                    for(int j : frame) {
                        if(min > candidate.get(j)) {
                            minKey = j;
                            min = candidate.get(j);
                            old = frame.indexOf(j);
                        } else if(min == candidate.get(j)) {
                            if(old > frame.indexOf(j)) {
                                minKey = j;
                                min = candidate.get(j);
                                old = frame.indexOf(j);
                            }
                        }
                    }
                    // 후보, 액자에서 제거
                    frame.remove(old);
                    candidate.remove(minKey);

                    // 후보, 액자에 등록
                    frame.add(student[i]);
                    candidate.put(student[i], 1);
                }
            }
        }

        Collections.sort(frame);
        for(int i : frame)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
