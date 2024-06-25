package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        String result = "";
        result += "<";

        while(!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int num = queue.poll();
                queue.add(num);
            }

            result += String.valueOf(queue.poll());
            if (!queue.isEmpty()){
                result += ", ";
            }
        }

        result += ">";
        System.out.println(result.toString());
    }
}
