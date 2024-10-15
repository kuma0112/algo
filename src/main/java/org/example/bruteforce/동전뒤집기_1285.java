package org.example.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class 동전뒤집기_1285 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
    public static void solution() throws IOException {
        int ans = Integer.MAX_VALUE;
        for(int bitCase = 0; bitCase<(1<<n);bitCase++){
            int sum = 0;
            for(int j=0;j<n;j++){
                int count = 0;
                for(int i=0;i<n;i++){
                    char tmp = map[i][j];
                    if(( bitCase & (1<<i) ) != 0) {
                        tmp = reverse(tmp);
                    }
                    if(tmp == 'T')  count += 1;
                }
                // 위에서 나온 각 조합마다 열 뒤집기를 수행한다
                // 열에 있는 T개수, 뒤집었을 때의 T개수 -> 뒤집었을 때가 더 적으면 -> 뒤집는다 -> 해당 T의 개수를 sum에 추가
                sum += min(count,n-count);
            }
            // 이렇게 도출된 뒤집기 수 중에 최소값을 찾는다
            ans = min(ans,sum);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static char reverse(char value){
        if( value=='T') return 'H';
        else return 'T';
    }

}
