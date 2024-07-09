package org.example.basic.alice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정리를좋아하는K씨 {
    static int n, m;
    static int[] array;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 8
        m = Integer.parseInt(st.nextToken()); // 3

        array = new int[n+1];
        st = new StringTokenizer(br.readLine()); // 1 7 6 8 1 6 4 5
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); // 1 5 3
            int start = Integer.parseInt(st.nextToken()); // 1
            int end = Integer.parseInt(st.nextToken()); // 5
            int num = Integer.parseInt(st.nextToken()); // 3

            int index = 0;
            int[] scope = new int[end-start+1];
            for (int j = start; j <= end ; j++) {
                scope[index] = array[j];
                index++;
            }
            Arrays.sort(scope);
            sb.append(scope[num-1]).append("\n");
        }
        System.out.println(sb);
    }
}
