package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceStrategyTest {

    PieceStrategy knightPieceStrategy;
    private static final int GRID_SIZE = 5;

    @BeforeEach
    void beforeEach(){
        knightPieceStrategy = new KnightPieceStrategy();
    }

    @Test
    void testLegalPosition() {
        final int knightLegalPosition = 0;
        assertFalse(knightPieceStrategy.isLegalPosition(knightLegalPosition, GRID_SIZE, GRID_SIZE));
        assertFalse(knightPieceStrategy.isLegalPosition(GRID_SIZE, knightLegalPosition, GRID_SIZE));
        assertFalse(knightPieceStrategy.isLegalPosition(GRID_SIZE, GRID_SIZE, GRID_SIZE));
        assertTrue(knightPieceStrategy.isLegalPosition(knightLegalPosition, knightLegalPosition, GRID_SIZE));
    }

}
