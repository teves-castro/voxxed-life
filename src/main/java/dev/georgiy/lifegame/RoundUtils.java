package dev.georgiy.lifegame;

import java.util.HashSet;
import java.util.Set;

public class RoundUtils {
    public static Set<Point> getNextGeneration(Set<Point> pointsSeeded) {
        Set<Point> newGenPoints = removeDiedPoints(pointsSeeded);

        Set<Point> deadNeighbors = new HashSet<>();
        pointsSeeded.forEach(p -> deadNeighbors.addAll(p.getNeighbourPoints()));
        deadNeighbors.removeAll(pointsSeeded);
        deadNeighbors.forEach(point -> {
            int count = point.countNeighborsInSet(pointsSeeded);
            if(count==3){ newGenPoints.add(point); }
        });
        return  newGenPoints;
    }

    private static Set<Point> removeDiedPoints(Set<Point> pointsSeeded) {
        Set<Point> newGenPoints = new HashSet<>();
        pointsSeeded.forEach(point -> {
            int count = point.countNeighborsInSet(pointsSeeded);
            if(count>=2 && count<=3){ newGenPoints.add(point); }
            //todo remove ifs
        });
        return newGenPoints;
    }


}
