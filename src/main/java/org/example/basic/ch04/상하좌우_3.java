package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우_3 {
/*
5
R R R U D D
 */
    static int n;
    static int[] dy4 = {-1, 1, 0, 0};
    static int[] dx4 = {0, 0, -1, 1};
    static String[] plans = {"U", "D", "L", "R"};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = 1, x = 1;

        while(st.hasMoreTokens()) {
            String token = st.nextToken();

            int nx = x;
            int ny = y;
            for (int i = 0; i < plans.length; i++) {
                if(plans[i].equals(token)) {
                    ny += dy4[i];
                    nx += dx4[i];
                }
            }

            if (ny < 1 || nx < 1 || ny > n || nx > n) continue;

            x = nx;
            y = ny;
        }
        System.out.println(y + " " + x);
    }
}
