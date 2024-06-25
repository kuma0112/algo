package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우 {
    static int[] dy4 = {-1, 1, 0, 0};
    static int[] dx4 = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfMap = Integer.parseInt(br.readLine());
        int[][] map = new int[sizeOfMap][sizeOfMap];
        int x = 1;
        int y = 1;
        String str = br.readLine(); // r r r u d d
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            int nx = x;
            int ny = y;

            switch (token) {
                case "U":
                    ny += dy4[0];
                    break;
                case "D":
                    ny += dy4[1];
                    break;
                case "L":
                    nx += dx4[2];
                    break;
                case "R":
                    nx += dx4[3];
                    break;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
