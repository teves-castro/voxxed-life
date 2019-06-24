package dev.georgiy.lifegame;

import java.util.Set;

public interface Point {
    Number getX();
    Number getY();
    int countNeighborsInSet(Set<Point> pointsSeeded);
    Set<Point> getNeighbourPoints();
}
