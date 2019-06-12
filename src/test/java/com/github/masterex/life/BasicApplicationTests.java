/**
 * Voxxed Days Athens 2019 - Game of Life.
 */
package com.github.masterex.life;

import com.github.masterex.life.models.Cell;
import com.github.masterex.life.models.Life;
import java.awt.Point;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void cellDiesFromUnderpopulation() {
        Life life = new Life();
        Cell cell = new Cell();
        cell.setAlive(true);
        cell.setPosition(new Point(0, 0));
        life.addCell(cell);

        assertFalse("List of cells is not empty.", life.getCells().isEmpty());
        assertTrue("Cell is not alive.", life.getCells().values().iterator().next().isAlive());

        Life mutatedLife = life.mutate();

        assertNotSame("The two life objects are the same", life, mutatedLife);
        assertFalse("Cell keeps living.", mutatedLife.getCells().containsKey(cell.getPosition()));
    }

    @Test
    public void cellKeepsLeaving() {
        Life life = new Life();

        Cell cell1 = new Cell();
        cell1.setAlive(true);
        cell1.setPosition(new Point(0, 0));
        life.addCell(cell1);

        Cell cell2 = new Cell();
        cell2.setAlive(true);
        cell2.setPosition(new Point(0, 1));
        life.addCell(cell2);

        Cell cell3 = new Cell();
        cell3.setAlive(true);
        cell3.setPosition(new Point(1, 0));
        life.addCell(cell3);

        assertTrue("List of cells does not contain 3 items.", life.getCells().size() == 3);
        assertTrue("Cell1 died.", life.getCells().get(cell1.getPosition()).isAlive());
        assertTrue("Cell2 died.", life.getCells().get(cell2.getPosition()).isAlive());
        assertTrue("Cell3 died.", life.getCells().get(cell3.getPosition()).isAlive());

        Life mutatedLife = life.mutate();

        assertNotSame("The two life objects are the same", life, mutatedLife);
        assertTrue("Cell1 died.", mutatedLife.getCells().get(cell1.getPosition()).isAlive());
        assertTrue("Cell2 died.", mutatedLife.getCells().get(cell2.getPosition()).isAlive());
        assertTrue("Cell3 died.", mutatedLife.getCells().get(cell3.getPosition()).isAlive());
    }

    @Test
    public void cellDiesFromOverpopulation() {
        Life life = new Life();

        Cell cell1 = new Cell();
        cell1.setAlive(true);
        cell1.setPosition(new Point(0, 0));
        life.addCell(cell1);

        Cell cell2 = new Cell();
        cell2.setAlive(true);
        cell2.setPosition(new Point(0, 1));
        life.addCell(cell2);

        Cell cell3 = new Cell();
        cell3.setAlive(true);
        cell3.setPosition(new Point(1, 0));
        life.addCell(cell3);

        Cell cell4 = new Cell();
        cell4.setAlive(true);
        cell4.setPosition(new Point(1, 1));
        life.addCell(cell4);

        Cell cell5 = new Cell();
        cell5.setAlive(true);
        cell5.setPosition(new Point(0, -1));
        life.addCell(cell5);

        assertTrue("List of cells does not contain 5 items.", life.getCells().size() == 5);

        Life mutatedLife = life.mutate();

        assertNotSame("The two life objects are the same", life, mutatedLife);
        assertTrue("Cell2 died.", mutatedLife.getCells().get(cell2.getPosition()).isAlive());
        assertTrue("Cell4 died.", mutatedLife.getCells().get(cell4.getPosition()).isAlive());
        assertTrue("Cell5 died.", mutatedLife.getCells().get(cell5.getPosition()).isAlive());
        assertFalse("Cell1 keeps living.", mutatedLife.getCells().containsKey(cell1.getPosition()));
        assertFalse("Cell3 keeps living.", mutatedLife.getCells().containsKey(cell3.getPosition()));
    }

    @Test
    public void cellLivesByReproduction() {
        Life life = new Life();

        Cell cell1 = new Cell();
        cell1.setAlive(true);
        cell1.setPosition(new Point(0, 0));
        life.addCell(cell1);

        Cell cell2 = new Cell();
        cell2.setAlive(true);
        cell2.setPosition(new Point(1, 0));
        life.addCell(cell2);

        Cell cell3 = new Cell();
        cell3.setAlive(true);
        cell3.setPosition(new Point(1, 1));
        life.addCell(cell3);

        assertTrue("List of cells does not contain 3 items.", life.getCells().size() == 3);

        Life mutatedLife = life.mutate();

        assertNotSame("The two life objects are the same", life, mutatedLife);
        assertTrue("Reproduction failed.", mutatedLife.getCells().get(new Point(0, 1)).isAlive());
    }

}
