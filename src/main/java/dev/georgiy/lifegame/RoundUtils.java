package dev.georgiy.lifegame;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class RoundUtils {

    private RoundUtils(){}

    public static Set<Point> getNextGeneration(Set<Point> pointsSeeded) {
        Set<Point> newGenPoints = calculateDiedPoints(pointsSeeded);
        newGenPoints.addAll(calculateBornPoints(pointsSeeded));
        return  newGenPoints;
    }

    private static Set<Point> calculateDiedPoints(Set<Point> pointsSeeded) {
        return pointsSeeded.stream()
                .filter(p -> {
                    int count = p.countNeighborsInSet(pointsSeeded);
                    return count >= 2 && count<= 3;
                })
                .collect(Collectors.toSet());
    }

    private static Set<Point> calculateBornPoints(Set<Point> pointsSeeded) {
        Set<Point> deadNeighbors = pointsSeeded.stream()
                .map(Point::getNeighbourPoints)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        deadNeighbors.removeAll(pointsSeeded);
        return deadNeighbors.stream().filter(p -> p.countNeighborsInSet(pointsSeeded)==3).collect(Collectors.toSet());

    }
}
