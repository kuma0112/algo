package org.example.basic.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
//        // 1 2 3 4 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // "1 2 3 4 5"라는 문자열. 이걸 공백을 기준으로 잘라야 한다.
//            // 이를 위해서는 StringTokenizer를 사용한다.
//            StringTokenizer st = new StringTokenizer(str);
//            System.out.println(st); // java.util.StringTokenizer@58644d46
//
//            int[] input = new int[5];
//            for (int i = 0; i < 5; i++) {
//                input[i] = Integer.parseInt(st.nextToken()); // "1" -> 1로 변환되는 과정
//            }
//            System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5]
//        }


//        // 1 A 3 B 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine();
//            StringTokenizer st = new StringTokenizer(str, " "); // 공백을 구분으로 해서 나누겠다는 뜻
//
//            char[] input = new char[5];
//            for (int i = 0; i < 5; i++) {
//                input[i] = st.nextToken().charAt(0); // "1" -> '1'로 변환
//            }
//            System.out.println(Arrays.toString(input)); // [1, A, 3, B, 5]
//        }


//         // XYZQU
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            char[] input = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(input)); // [X, Y, Z, Q, U]
//        }


///*
//6
//1 2 3 4 5 1
// */
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//            int[] input = new int[N];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int i = 0; i < N; i++) {
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5, 1]
//        }


///*
//5
//XYZQU
// */
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//            char[] input = br.readLine().toCharArray();
//
//            System.out.println(Arrays.toString(input)); // [X, Y, Z, Q, U]
//        }


/*
5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
 */

        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            System.out.println(N);

            int[][] input = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
                System.out.println();
            }

            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(input[i]));
            }



/*
[1, 2, 3, 4, 5]
[6, 7, 8, 9, 0]
[1, 2, 3, 4, 5]
[6, 7, 8, 9, 0]
[1, 2, 3, 4, 5]
 */
//        }

/*
3 5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
 */

//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine()); // "3 5"
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//            System.out.println(N); // 3
//            System.out.println(M); // 5
//
//            int[][] input = new int[N][M];
//
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < M; j++) {
//                    input[i][j] = Integer.parseInt(st.nextToken());
//                }
//                System.out.println();
//            }
//
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(input[i]));
//            }



            /*
[1, 2, 3, 4, 5]
[6, 7, 8, 9, 0]
[1, 2, 3, 4, 5]
             */
//        }


/* 첫 줄에 테스트 케이스 개수 (3), 둘째줄부터 테스트 케이스
각 테스트케이스는 첫 줄에 N, M이 주어지고 이어지는 N개의 줄에 M개의 수가 주어진다.
3
2 2
1 2
6 7
3 5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
2 1
8
9

 */
//        {
////            System.setIn(new FileInputStream("input.txt"));
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int T = Integer.parseInt(br.readLine());
//
//            for (int t = 1; t <= T; t ++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int N = Integer.parseInt(st.nextToken());
//                int M = Integer.parseInt(st.nextToken());
//
//                int[][] input = new int[N][M];
//                for (int i = 0; i < N; i++) {
//                    st = new StringTokenizer(br.readLine());
//                    for (int j = 0; j < M; j++) {
//                        input[i][j] = Integer.parseInt(st.nextToken());
//                    }
//                }
//                // 출력
//                System.out.println(t);
//                for (int i = 0; i < N; i++) {
//                    System.out.println(Arrays.toString(input[i]));
//                }
//            }
        }
    }
}
