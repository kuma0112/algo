package org.example.recursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수_1300 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(1, N*N));
    }

    static int binarySearch(int start, int end) {
        int answer = 0;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int count = 0;
            for (int i = 1; i <= N ; i++) {
                count += Math.min(mid/i, N);
            }

            // count가 M(추정하고자 하는 인덱스) 이상이면 B[M]의 값은 현재의 mid보다 작거나 같다는 의미. 따라서 현재 mid에서 가능한 답을 일단 적어두고 end를 줄여서 더 작은 값을 탐색
            if (count >= M) {
                answer = mid;
                end = mid - 1;
            } else {
                // B[M]이 현재 mid보다 크다는 의미
                start = mid + 1;
            }
        }
        return answer;
    }
}
