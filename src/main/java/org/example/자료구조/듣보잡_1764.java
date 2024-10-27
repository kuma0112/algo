package org.example.자료구조;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_1764 {
    static int N, M;
    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> name;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name,map.getOrDefault(name,0)+1);
        }

        name = new ArrayList<>();
        int count = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                count++;
                name.add(entry.getKey());
            }
        }

        System.out.println(count);
        Collections.sort(name);
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i));
        }
    }
}
