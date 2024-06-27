package org.example.basic.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_4 {
    static int n, r, c, answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);

//        solve(0,0);
        z(0,0);
        System.out.println(answer);
    }

    static void solve(int y, int x) {
        while(true) {
            if (n == 1) {
                return;
            }

            n = n/2;

            if (r < y + n && c < x + n) {

            } else if (r < y + n && c >= x + n) {
                x += n;
                answer += n*n;
            } else if (r >= y + n && c < x + n) {
                y += n;
                answer += n*n*2;
            } else if (r >= y + n && c >= x + n) {
                x += n;
                y += n;
                answer += n * n * 3;
            }
        }
    }

    static void z (int y, int x) {
        if (n==1) return;
        n /= 2;
        if(r < y + n && c < x + n) {
            z(y,x);
        } else if (r < y + n && c >= x + n) {
            answer += n * n;
            z(y,x+n);

        }else if (r >= y + n && c < x + n) {
            answer += n * n * 2;
            z(y+n,x);

        }else if (r  >=  y + n && c >= x + n) {
            answer += n * n * 3;
            z(y+n,x+n);

        }
    }
}
