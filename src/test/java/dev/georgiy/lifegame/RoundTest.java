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
        Assert.assertFalse(nextGenPoints.contains(new PointIntImpl(0, 1)));
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

    @Test
    public void pointDiesOverpopulated(){
        Set<Point> pointsSeeded = new HashSet<>();
        pointsSeeded.add(new PointIntImpl(0,1));
        pointsSeeded.add(new PointIntImpl(0,0));
        pointsSeeded.add(new PointIntImpl(0,2));
        pointsSeeded.add(new PointIntImpl(1,1));
        pointsSeeded.add(new PointIntImpl(-1,1));
        Set<Point> nextGenPoints = RoundUtils.getNextGeneration(pointsSeeded);
        Assert.assertFalse(nextGenPoints.contains(new PointIntImpl(0, 1)));
    }

    @Test
    public void pointBorn(){
        Set<Point> pointsSeeded = new HashSet<>();
        pointsSeeded.add(new PointIntImpl(0,0));
        pointsSeeded.add(new PointIntImpl(0,2));
        pointsSeeded.add(new PointIntImpl(1,1));
        Set<Point> nextGenPoints = RoundUtils.getNextGeneration(pointsSeeded);
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(0,1)));
    }

    @Test
    public void multiplePointsTest(){
        Set<Point> pointsSeeded = new HashSet<>();
        pointsSeeded.add(new PointIntImpl(1,0));
        pointsSeeded.add(new PointIntImpl(2,0));
        pointsSeeded.add(new PointIntImpl(3,0));
        pointsSeeded.add(new PointIntImpl(4,0));
        pointsSeeded.add(new PointIntImpl(5,0));
        Set<Point> nextGenPoints = RoundUtils.getNextGeneration(pointsSeeded);
        Assert.assertEquals(9, nextGenPoints.size());
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(2,0)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(2,-1)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(2,1)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(3,0)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(3,-1)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(3,1)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(3,0)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(3,-1)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(3,1)));
    }


    @Test
    public void endlessFieldTest(){
        Set<Point> pointsSeeded = new HashSet<>();
        pointsSeeded.add(new PointIntImpl(0,Integer.MAX_VALUE));
        pointsSeeded.add(new PointIntImpl(1,Integer.MAX_VALUE));
        pointsSeeded.add(new PointIntImpl(2,Integer.MAX_VALUE));
        Set<Point> nextGenPoints = RoundUtils.getNextGeneration(pointsSeeded);
        Assert.assertEquals(3, nextGenPoints.size());
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(1,Integer.MIN_VALUE)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(1,Integer.MAX_VALUE)));
        Assert.assertTrue(nextGenPoints.contains(new PointIntImpl(1,Integer.MAX_VALUE-1)));
    }
}
