package dev.georgiy.lifegame;

import java.util.HashSet;
import java.util.Set;

public class RoundUtils {
    public static Set<Point> getNextGeneration(Set<Point> pointsSeeded) {
        Set<Point> newGenPoints = new HashSet<>();
        //removing the dieing points
        pointsSeeded.forEach(point -> {
            int count = point.countNeighborsInSet(pointsSeeded);
            if(count>=2 && count<=3){ newGenPoints.add(point); }
            //todo remove ifs
        });
        Set<Point> deadNeighbors = new HashSet<>();
        pointsSeeded.forEach(p -> deadNeighbors.addAll(p.getNeighbourPoints()));
        deadNeighbors.removeAll(pointsSeeded);
        deadNeighbors.forEach(point -> {
            int count = point.countNeighborsInSet(pointsSeeded);
            if(count==3){ newGenPoints.add(point); }
        });
        return  newGenPoints;
    }
}
