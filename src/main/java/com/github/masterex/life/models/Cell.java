/**
 * Voxxed Days Athens 2019 - Game of Life.
 */
package com.github.masterex.life.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
@Data
public class Cell {

    private Point position;
    @JsonIgnore
    private boolean alive;

    public Cell() {
    }

    public Cell(Point position) {
        this.position = position;
    }

    @JsonIgnore
    public Set<Point> getNeighbours() {
        Set<Point> neighbours = new HashSet<>();
        neighbours.add(new Point(position.x - 1, position.y));
        neighbours.add(new Point(position.x - 1, position.y - 1));
        neighbours.add(new Point(position.x, position.y - 1));
        neighbours.add(new Point(position.x + 1, position.y - 1));
        neighbours.add(new Point(position.x + 1, position.y));
        neighbours.add(new Point(position.x, position.y + 1));
        neighbours.add(new Point(position.x + 1, position.y + 1));
        neighbours.add(new Point(position.x - 1, position.y + 1));
        return neighbours;
    }

    public long aliveNeighborCount(Life life) {
        Set<Point> neighbors = getNeighbours();
        return neighbors.stream()
                .filter(n -> life.getCells().containsKey(n) && life.getCells().get(n).isAlive())
                .count();
    }

}
