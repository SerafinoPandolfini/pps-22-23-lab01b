package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

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

    public enum Click {
        LEFT,
        RIGHT
    }

    private void clickAllCell(Click clickType) {
        IntStream.rangeClosed(0, SIZE - 1).forEach(x ->
                IntStream.rangeClosed(0, SIZE - 1).forEach(y -> {
                    if (clickType.equals(Click.RIGHT)) {
                        logics.clickCell(new Pair<>(x, y));
                    }
                    if (clickType.equals(Click.LEFT)) {
                        logics.leftClickCell(new Pair<>(x, y));
                    }
                })
        );
    }

    @Test
    void testCellCounter() {
        clickAllCell(Click.RIGHT);
        logics.getNotMinesClickedCell().forEach(t -> assertTrue(t.getValue() >= 0));
    }

    @Test
    void testFlaggedCell() {
        int numberOfFlaggedCells = 1;
        logics.leftClickCell(minePosition);
        assertEquals(numberOfFlaggedCells, logics.getFlaggedCellSet().size());
        numberOfFlaggedCells = SIZE * SIZE;
        logics.leftClickCell(minePosition);
        clickAllCell(Click.LEFT);
        assertEquals(numberOfFlaggedCells, logics.getFlaggedCellSet().size());
    }

    @Test
    void testAutoClickedCell() {
        int numberOfUserClickedCell = 1;
        CellCounterStrategy cellCounterStrategy = new CellCounterStrategyImpl(SIZE, logics.getSetOfMines());
        Pair<Integer, Integer> zeroValueCell;
        do {
            zeroValueCell = new Pair<>(this.random.nextInt(SIZE), this.random.nextInt(SIZE));
        } while (logics.getSetOfMines().contains(notMinePosition) ||
                cellCounterStrategy.cellValue(zeroValueCell) > 0);
        logics.clickCell(zeroValueCell);
        assertNotEquals(numberOfUserClickedCell, logics.getNotMinesClickedCell().size());
    }
}

