package br.com.loom.copypaste.random;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class PictureOfTrees {

    static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double x, y;
        double theta;
        long count;
    }

    public static void main(String[] args) {

        double cameraFov = 70 * Math.PI / 180;

        Set<Point> trees = Set.of(
                new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, -0.25), new Point(1, -0.5), new Point(1, -1), new Point(-1, 0), new Point(-1, 1), new Point(-1, -1), new Point(-1, -1.5)
        );
        trees.forEach(point -> point.theta = Math.atan2(point.y, point.x));
        SortedSet<Point> sortedTrees = new TreeSet<>(Comparator.comparingDouble(p -> p.theta));
        sortedTrees.addAll(trees);

        double bestAngle = sortedTrees.stream()
                .peek(curr -> curr.count = sortedTrees.stream()
                        .filter(p ->
                                ((p.theta >= curr.theta) && p.theta <= (curr.theta + cameraFov)) ||
                                        (p.theta <= (curr.theta + cameraFov - Math.PI * 2))
                        )
                        .count())
                .max(Comparator.comparingLong(p -> p.count))
                .map(curr -> (curr.theta + cameraFov / 2) * 180 / Math.PI)
                .orElseThrow();

        sortedTrees.forEach(System.out::println);

        System.out.println(bestAngle);
    }
}
