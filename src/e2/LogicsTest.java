package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    private static final int SIZE = 7;
    private static final int MINES = 10;
    private static final int OUT_OF_BOUND_POSITION = -1;
    private Logics logics;
    private final Random random = new Random();
    private Pair<Integer, Integer> notMinePosition;
    private Pair<Integer, Integer> minePosition;

    @BeforeEach
    void beforeEach(){
        logics = new LogicsImpl(SIZE, MINES);
        notMinePosition = getNotMinePosition(logics.getSetOfMines());
        minePosition = logics.getSetOfMines().stream().findFirst().orElse(
                new Pair<>(OUT_OF_BOUND_POSITION, OUT_OF_BOUND_POSITION));
    }

    private Pair<Integer, Integer> getNotMinePosition(Set<Pair<Integer,Integer>> mineSet){
        Pair<Integer, Integer> notMinePosition;
        do {
            notMinePosition = new Pair<>(this.random.nextInt(SIZE), this.random.nextInt(SIZE));
        } while (mineSet.contains(notMinePosition));
        return notMinePosition;
    }

    @Test
    void testMinesPlacement() {
        assertEquals(MINES, logics.getSetOfMines().size());
    }

    @Test
    void testClickOnMine() {
        assertTrue(logics.clickCell(minePosition));
        assertFalse(logics.clickCell(notMinePosition));
    }

    @Test
    void testClickOnNotMine() {
        logics.clickCell(minePosition);
        assertEquals(0, logics.getNotMinesClickedCell().size());
        logics.clickCell(notMinePosition);
        assertEquals(1, logics.getNotMinesClickedCell().size());
    }

    @Test
    void testCellCounter() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                logics.clickCell(new Pair<>(i, j));
            }
        }
        logics.getNotMinesClickedCell().forEach(t -> assertTrue(t.getValue() >= 0));
    }
}

