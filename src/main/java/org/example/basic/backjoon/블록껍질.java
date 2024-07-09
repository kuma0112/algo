package org.example.basic.backjoon;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class 블록껍질 {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt(); // 점의 개수 입력 받기
        Point2D[] points = new Point2D[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point2D.Double(scanner.nextDouble(), scanner.nextDouble()); // 점의 좌표 입력 받기
        }

        Point2D[] convexHull = getConvexHull(points); // 볼록 껍질 찾기

        System.out.println(convexHull.length); // 볼록 껍질의 점 개수 출력
        for (Point2D point : convexHull) {
            System.out.printf("%.0f %.0f\n", point.getX(), point.getY()); // 볼록 껍질의 점들 출력
        }
    }

    public static Point2D[] getConvexHull(Point2D[] points) {
        int n = points.length;
        if (n < 3) return points; // 점이 3개 미만이면 그대로 반환

        Point2D[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints, Comparator.comparing(Point2D::getY).thenComparing(Point2D::getX)); // 가장 아래 왼쪽 점 찾기
        Point2D start = sortedPoints[0];

        Arrays.sort(sortedPoints, 1, n, new PolarAngleComparator(start)); // 각도를 기준으로 정렬

        Stack<Point2D> stack = new Stack<>();
        stack.push(sortedPoints[0]);
        stack.push(sortedPoints[1]);

        for (int i = 2; i < n; i++) {
            Point2D top = stack.pop();
            while (ccw(stack.peek(), top, sortedPoints[i]) <= 0) { // 반시계 방향 확인
                top = stack.pop();
            }
            stack.push(top);
            stack.push(sortedPoints[i]);
        }

        return stack.toArray(new Point2D[0]);
    }

    private static int ccw(Point2D a, Point2D b, Point2D c) {
        double area = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
        return Double.compare(area, 0); // 반시계 방향 체크
    }

    private static class PolarAngleComparator implements Comparator<Point2D> {
        private final Point2D reference;

        public PolarAngleComparator(Point2D reference) {
            this.reference = reference;
        }

        @Override
        public int compare(Point2D p1, Point2D p2) {
            double angle1 = Math.atan2(p1.getY() - reference.getY(), p1.getX() - reference.getX());
            double angle2 = Math.atan2(p2.getY() - reference.getY(), p2.getX() - reference.getX());
            return Double.compare(angle1, angle2); // 각도를 기준으로 정렬
        }
    }
}
