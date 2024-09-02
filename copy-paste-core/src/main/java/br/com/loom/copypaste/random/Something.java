package br.com.loom.copypaste.random;

// you can also use imports, for example:
// import java.util.*;

import java.util.Set;

/**
 * Test Cases: 
 *
 * (1, 0), (1, 1), (1, 2), (-1, 1), (-1, -1) and (-1, 0): 35
 * (1, 0), (1, 1), (1, 2), (1, -0.25), (1, -0.5), (1, -1), (-1, 0), (-1, 1), (-1, -1), (-1, -1.5): 350
 * (1, 0), (1, 1), (1, 2), (-1, 1), (-1, -1), (-1, -0.25), (-1, -0.5), (-1, 0), (-1, -1.5): 215
 */
public class Something {

    public static void main(String[] args) {

        double cameraFov = 70;

        double bestAngle = 0;

        Set<Point> trees = Set.of(
                new Point(1, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(-1, 1),
                new Point(-1, -1),
                new Point(-1, 0)
        );

        // Some code here

        System.out.println(bestAngle);

    }

    static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double x, y;
    }

}


