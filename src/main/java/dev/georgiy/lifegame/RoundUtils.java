package dev.georgiy.lifegame;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RoundUtils {
    public static Set<Point> getNextGeneration(Set<Point> pointsSeeded) {
        Set<Point> newGenPoints = calculateDiedPoints(pointsSeeded);
        newGenPoints.addAll(calculateBornPoints(pointsSeeded));
        return  newGenPoints;
    }

    private static Set<Point> calculateDiedPoints(Set<Point> pointsSeeded) {

        return pointsSeeded.stream()
                .filter(p -> p.countNeighborsInSet(pointsSeeded)>=2
                        && p.countNeighborsInSet(pointsSeeded)<=3)
                .collect(Collectors.toSet());

    }

    private static Set<Point> calculateBornPoints(Set<Point> pointsSeeded) {
        Set<Point> newGenPoints = new HashSet<>();
        Set<Point> deadNeighbors = new HashSet<>();
        pointsSeeded.forEach(p -> deadNeighbors.addAll(p.getNeighbourPoints()));
        deadNeighbors.removeAll(pointsSeeded);
        deadNeighbors.forEach(point -> {
            int count = point.countNeighborsInSet(pointsSeeded);
            if (count == 3) {
                newGenPoints.add(point);
            }
            //todo remove ifs
        });
        return newGenPoints;
    }



}
