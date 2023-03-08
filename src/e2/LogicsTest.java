package e2;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicsTest {

    private static final int SIZE = 7;
    private static final int MINES = 10;
    private Logics logics;

    @BeforeEach
    void beforeEach(){
        logics = new LogicsImpl(SIZE, MINES);
    }

    @Test
    void testMinesPlacement() {
        assertEquals(MINES, logics.getSetOfMines().size());
    }
}

