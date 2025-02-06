package org.example.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사상어와파이어볼_20056 {
    static int N, M, K;
    static List<Fireball>[][] board;
    static List<Fireball> balls;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new ArrayList[N+1][N+1];
        balls = new ArrayList<>();
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Fireball fireball = new Fireball(a, b, c, d, e);

            board[a][b].add(fireball);
            balls.add(fireball);
        }
        while (K --> 0) {
            move();

            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= N ; j++) {
                    if (board[i][j].size() >= 2) {
                        combineAndDivide(i,j,board[i][j]);
                    }
                }
            }
            cleanList();
        }
        int answer = 0;
        for(Fireball ball: balls) {
            answer += ball.mass;
        }
        System.out.println(answer);
    }

    public static void cleanList(){
        balls = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(board[i][j].size() > 0){
                    for(Fireball b:board[i][j]){
                        balls.add(b);
                    }
                }
            }
        }
    }

    static void move () {
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for(Fireball ball: balls) {
            int y = ball.y;
            int x = ball.x;
            int mass = ball.mass;
            int speed = ball.speed;
            int direction = ball.direction;
            int ny = y + ((speed%N) * dy[direction]);
            int nx = x + ((speed%N) * dx[direction]);

            if (ny <= 0) ny += N;
            if (nx <= 0) nx += N;
            if (ny > N) ny -= N;
            if (nx > N) nx -= N;

            ball.y = ny;
            ball.x = nx;
            board[ny][nx].add(ball);
        }

    }

    static void combineAndDivide (int y, int x, List<Fireball> balls) {
        int massSum = 0, speedSum = 0;
        boolean isEven = true;
        boolean isOdd = true;
        for(Fireball ball : balls) {
            massSum += ball.mass;
            speedSum += ball.speed;
            if (ball.direction % 2 == 0) {
                isOdd = false;
            } else {
                isEven = false;
            }
        }

        int newMass = massSum/5;
        int newSpeed = speedSum/balls.size();
        int[] directions = {0, 2, 4, 6};
        if (!isOdd && !isEven) {
            directions[0] = 1; directions[1] = 3; directions[2] = 5; directions[3] = 7;
        }

        board[y][x] = new ArrayList<>();
        if(newMass <= 0) return;
        for(int d: directions) {
            board[y][x].add(new Fireball(y, x, newMass, newSpeed, d));
        }
    }


    static class Fireball{
        int y;
        int x;
        int mass;
        int speed;
        int direction;

        Fireball (int y, int x, int mass, int speed, int direction) {
            this.y = y;
            this.x = x;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }
}
