package dev.georgiy.lifegame;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PointIntImpl implements Point{
    private int x;
    private int y;

    public PointIntImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Number getX() {
        return x;
    }

    @Override
    public Number getY() {
        return y;
    }

    public Set<Point> getNeighbourPoints() {
        Set<Point> neighbours = new HashSet<>();
        neighbours.add(new PointIntImpl(x+1, y));
        neighbours.add(new PointIntImpl(x+1, y-1));
        neighbours.add(new PointIntImpl(x-1, y+1));
        neighbours.add(new PointIntImpl(x-1, y));
        neighbours.add(new PointIntImpl(x-1, y-1));
        neighbours.add(new PointIntImpl(x+1, y+1));
        neighbours.add(new PointIntImpl(x, y-1));
        neighbours.add(new PointIntImpl(x, y+1));
        return neighbours;
    }

    public int countNeighborsInSet(Set<Point> pointsSeeded){
        Set<Point> neighborsPresent = this.getNeighbourPoints();
        neighborsPresent.retainAll(pointsSeeded);
        return neighborsPresent.size();
    }

    @Override
    public boolean equals(Object o) {
        return this == o
                || o instanceof Point && getX().equals(((Point)o).getX()) &&
                getY().equals(((Point)o).getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)", x, y);
    }
}
