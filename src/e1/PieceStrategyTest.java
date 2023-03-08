package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceStrategyTest {

    PieceStrategy knightPieceStrategy;
    private static final int GRID_SIZE = 5;
    private static final int LEGAL_POSITION = 0;

    @BeforeEach
    void beforeEach() {
        knightPieceStrategy = new KnightPieceStrategy();
    }

    @Test
    void testLegalPosition() {
        assertTrue(knightPieceStrategy.isOutOfBounds(new Pair<>(LEGAL_POSITION, GRID_SIZE), GRID_SIZE));
        assertTrue(knightPieceStrategy.isOutOfBounds(new Pair<>(GRID_SIZE, LEGAL_POSITION), GRID_SIZE));
        assertTrue(knightPieceStrategy.isOutOfBounds(new Pair<>(GRID_SIZE, GRID_SIZE), GRID_SIZE));
        assertFalse(knightPieceStrategy.isOutOfBounds(new Pair<>(LEGAL_POSITION, LEGAL_POSITION), GRID_SIZE));
    }

    @Test
    void testMovementFeasible() {
        Pair<Integer, Integer> knightPosition = new Pair<>(LEGAL_POSITION, LEGAL_POSITION);
        Pair<Integer, Integer> knightIllegalMovement = new Pair<>(2,2);
        Pair<Integer, Integer> knightLegalMovement = new Pair<>(2,1);
        assertFalse(knightPieceStrategy.isMovementFeasible(knightPosition, knightIllegalMovement.getX(),
                knightIllegalMovement.getY()));
        assertTrue(knightPieceStrategy.isMovementFeasible(knightPosition, knightLegalMovement.getX(),
                knightLegalMovement.getY()));
    }

    @Test
    void testPawnIsEaten() {
        final int differentLegalPosition = LEGAL_POSITION + 1;
        Pair<Integer, Integer> pairPosition = new Pair<>(LEGAL_POSITION, LEGAL_POSITION);
        Pair<Integer, Integer> differentPairPosition = new Pair<>(LEGAL_POSITION, differentLegalPosition);
        assertFalse(knightPieceStrategy.pawnIsEaten(pairPosition, differentPairPosition));
        assertTrue(knightPieceStrategy.pawnIsEaten(pairPosition, pairPosition));
    }

}
