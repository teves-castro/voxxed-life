/**
 * Voxxed Days Athens 2019 - Game of Life.
 */
package com.github.masterex.life.models;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
@Data
public class Life {

    private Map<Point, Cell> cells = new HashMap<>();

    public Life() {
    }

    public Life(LifeDTO lifeDTO) {
        lifeDTO.getCells().stream()
                .forEach(cell -> {
                    cell.setAlive(true);
                    cells.put(cell.getPosition(), cell);
                });
    }

    public Life mutate() {
        Life life = new Life();
        Set<Point> neighborReproductionCandidateCells = neighborCells();
        cells.values().stream()
                .forEach(cell -> life.addCell(mutateCell(cell)));
        neighborReproductionCandidateCells.stream()
                .forEach(cellPosition -> life.addCell(mutateCell(new Cell(cellPosition))));
        return life;
    }

    private Cell mutateCell(Cell cell) {
        return mutateCell(cell.getPosition(), cell.isAlive(), cell.aliveNeighborCount(this));
    }

    private Cell mutateCell(Point p, Boolean alive, long liveNeighbours) {
        Cell newCell = new Cell();
        newCell.setPosition(p);
        newCell.setAlive(alive && (liveNeighbours == 2 || liveNeighbours == 3) || (!alive && liveNeighbours == 3));
        return newCell;
    }

    public void addCell(Cell cell) {
        if (cell.isAlive()) {
            cells.put(cell.getPosition(), cell);
        }
    }

    private Set<Point> neighborCells() {
        Set<Point> neighborCandidateCells = new HashSet<>();
        cells.values().stream()
                .forEach(cell -> neighborCandidateCells.addAll(cell.getNeighbours()));
        neighborCandidateCells.removeIf(cell -> cells.containsKey(cell.getLocation()));
        return neighborCandidateCells;
    }

    public LifeDTO getLifeDTO() {
        LifeDTO lifeDTO = new LifeDTO();
        lifeDTO.getCells().addAll(cells.values());
        return lifeDTO;
    }

}
