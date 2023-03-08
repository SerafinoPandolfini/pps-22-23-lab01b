package e2;

import e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    private static final int SIZE = 7;
    private static final int MINES = 10;
    private static final int OUT_OF_BOUND_POSITION = -1;
    private Logics logics;
    private final Random random = new Random();

    @BeforeEach
    void beforeEach(){
        logics = new LogicsImpl(SIZE, MINES);
    }

    @Test
    void testMinesPlacement() {
        assertEquals(MINES, logics.getSetOfMines().size());
    }

    @Test
    void testClickOnMine() {
        Pair<Integer, Integer> notMinePosition;
        Pair<Integer, Integer> minePosition = logics.getSetOfMines().stream().findFirst().orElse(
            new Pair<>(OUT_OF_BOUND_POSITION, OUT_OF_BOUND_POSITION));
        assertTrue(logics.isMine(minePosition));

        do {
            notMinePosition = new Pair<>(this.random.nextInt(SIZE), this.random.nextInt(SIZE));
        } while (logics.getSetOfMines().contains(notMinePosition));
        assertFalse(logics.isMine(notMinePosition));

    }
}

