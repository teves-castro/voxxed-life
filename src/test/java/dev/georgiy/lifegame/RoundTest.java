package dev.georgiy.lifegame;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class RoundTest {
    @Test
    public void pointDiesNoNeighbors(){
        Set<Point> pointsSeeded = new HashSet<>();
        pointsSeeded.add(new PointIntImpl(0,1));
        pointsSeeded.add(new PointIntImpl(0,0));
        Set<Point> nextGenPoints = RoundUtils.getNextGeneration(pointsSeeded);
        Assert.assertTrue(!nextGenPoints.contains(new PointIntImpl(0,1)));
    }

    @Test
    public void pointStays(){
        Set<Point> pointsSeeded = new HashSet<>();
        pointsSeeded.add(new PointIntImpl(0,1));
        pointsSeeded.add(new PointIntImpl(0,0));
        pointsSeeded.add(new PointIntImpl(1,1));
        Set<Point> nextGenPoints = RoundUtils.getNextGeneration(pointsSeeded);
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(0,0)));
    }
}
