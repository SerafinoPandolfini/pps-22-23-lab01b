package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int GRID_SIZE = 5;
    private static final int PAWN_X_POSITION = 2;
    private static final int PAWN_Y_POSITION = 1;
    private static final int KNIGHT_X_POSITION = 3;
    private static final int KNIGHT_Y_POSITION = 3;
    private Logics logics;

    @BeforeEach
    void beforeEach(){
        logics = new LogicsImpl(GRID_SIZE, new Pair<>(KNIGHT_X_POSITION, KNIGHT_Y_POSITION),
                new Pair<>(PAWN_X_POSITION,PAWN_Y_POSITION));
    }

    @Test
    void testInitialPosition() {
        assertTrue(logics.hasKnight(KNIGHT_X_POSITION, KNIGHT_Y_POSITION));
        assertTrue(logics.hasPawn(PAWN_X_POSITION, PAWN_Y_POSITION));
    }

    @Test
    void testMovingKnight() {
        final int knightNewXPosition = KNIGHT_X_POSITION - 2;
        final int knightNewYPosition = KNIGHT_Y_POSITION - 1;
        assertFalse(logics.hit(knightNewXPosition, knightNewYPosition));
        assertTrue(logics.hasKnight(knightNewXPosition, knightNewYPosition));
    }

    @Test
    void testMovingKnightOutOfBounds(){
        final int knightNewXPosition = KNIGHT_X_POSITION + 2;
        final int knightNewYPosition = KNIGHT_Y_POSITION + 1;
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(knightNewXPosition, knightNewYPosition));
    }

    @Test
    void testKnightEatPawn(){
        final int knightNewXPosition = KNIGHT_X_POSITION - 1;
        final int knightNewYPosition = KNIGHT_Y_POSITION - 2;
        assertTrue(logics.hit(knightNewXPosition, knightNewYPosition));
    }
}
