package org.example.basic.delta;

public class DeltaTest3 {

    public static void main(String[] args) {
        String[] park = new String[]{"SOO", "OXX", "OOO"};
        String[] routes = new String[]{"E 2", "S 2", "W 1"};
        turnToMap(park);
        walk(routes);
        System.out.println(startPointX + " " + startPointY);
    }

    static int[] dy4 = {-1, 1, 0, 0};
    static int[] dx4 = {0, 0, -1, 1};


    static void walk(String[] routes) {
        for (String str : routes) {
            String route = str;
            String direction = String.valueOf(route.charAt(0));
            int step = Integer.parseInt(String.valueOf(route.charAt(2)));

            int ny = startPointY;
            int nx = startPointX;

            for (int i = 0; i < step; i++) {
                if (direction.equals("N")) startPointY = startPointY + dy4[0];
                if (direction.equals("S")) startPointY = startPointY + dy4[1];
                if (direction.equals("W")) startPointX = startPointX + dx4[2];
                if (direction.equals("E")) startPointX = startPointX + dx4[3];

                if (startPointY < 0 || startPointX < 0 || startPointY >= map.length || startPointX >= map[0].length || map[startPointY][startPointX] == 'X') {
                    startPointX = nx;
                    startPointY = ny;
                    break;
                }
            }


        }
    }

    static char[][] map;
    static int startPointY;
    static int startPointX;

    static char[][] turnToMap(String[] park) {
        map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            String str = park[i];
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    startPointY = i;
                    startPointX = j;
                }
            }
        }
        return map;
    }

}
