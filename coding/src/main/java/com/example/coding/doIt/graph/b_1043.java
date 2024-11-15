package com.example.coding.doIt.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b_1043 {
    static ArrayList<Integer> truth = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 입력 받기
        st = new StringTokenizer(br.readLine().trim());
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        // 인접리스트 선언
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        for(int j = 0; j < n + 1; j++) {
            graph[j] = new ArrayList<>();
        }

        // 파티 입력 받기
        ArrayList<Integer>[] partyList = new ArrayList[m];
        for(int i = 0; i < m; i++) {
            partyList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int partyNum = Integer.parseInt(st.nextToken());
            int[] party = new int[partyNum];
            for (int j = 0; j < partyNum; j++) {
                party[j] = Integer.parseInt(st.nextToken());
                partyList[i].add(party[j]);
            }

            // 양방향으로 넣어주기
            for(int j = 0; j < partyNum; j++) {
                for(int h = j + 1; h < partyNum; h++) {
                    graph[party[j]].add(party[h]);
                    graph[party[h]].add(party[j]);
                }
            }
        }

        // 파티에 참여하여 진실을 알게 된 사람을 dfs 로 수행
        for(int i = 0; i < k;  i++) {
            if(!visited[truth.get(i)]) {
                dfs(graph, visited, truth.get(i));
            }
        }

        //  모든 파티 종료 후 각 파티에서 진실을 아는 사람이 아무도 없는 파티 수 세기
        int count = 0;
        for(int i = 0; i < m; i++) {
            boolean check = false;
            for(int j = 0; j < truth.size(); j++) {
                if(partyList[i].contains(truth.get(j))) {
                    check = true;
                }
            }
            if(!check) count += 1;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int num) {
        // 방문처리
        visited[num] = true;

        // 인접한 그래프 탐색
        for(int i = 0; i < graph[num].size(); i++) {
            int ni = graph[num].get(i);

            if(!visited[ni]) {
                truth.add(ni);
                dfs(graph, visited, ni);
            }
        }
    }
}
