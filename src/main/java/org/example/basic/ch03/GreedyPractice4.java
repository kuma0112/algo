package org.example.basic.ch03;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyPractice4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int theNumberOfMeeting = Integer.parseInt(br.readLine());
        int[][] arrayOfMeeting = new int[theNumberOfMeeting][2];

        for (int i = 0; i < theNumberOfMeeting; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 1 4
            arrayOfMeeting[i][0] = Integer.parseInt(st.nextToken());
            arrayOfMeeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrayOfMeeting, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < theNumberOfMeeting; i++) {
            if (arrayOfMeeting[i][0] >= endTime) {
                endTime = arrayOfMeeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
