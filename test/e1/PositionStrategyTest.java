package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionStrategyTest {

    PositionStrategy positionStrategy;
    private static final int GRID_SIZE = 5;
    private static final int LEGAL_POSITION = 0;

    @BeforeEach
    void beforeEach() {
        positionStrategy = new PositionStrategyImpl();
    }

    @Test
    void testLegalPosition() {
        assertTrue(positionStrategy.isOutOfBounds(new Pair<>(LEGAL_POSITION, GRID_SIZE), GRID_SIZE));
        assertTrue(positionStrategy.isOutOfBounds(new Pair<>(GRID_SIZE, LEGAL_POSITION), GRID_SIZE));
        assertTrue(positionStrategy.isOutOfBounds(new Pair<>(GRID_SIZE, GRID_SIZE), GRID_SIZE));
        assertFalse(positionStrategy.isOutOfBounds(new Pair<>(LEGAL_POSITION, LEGAL_POSITION), GRID_SIZE));
    }

    @Test
    void testMovementFeasible() {
        Pair<Integer, Integer> knightPosition = new Pair<>(LEGAL_POSITION, LEGAL_POSITION);
        Pair<Integer, Integer> knightIllegalMovement = new Pair<>(2,2);
        Pair<Integer, Integer> knightLegalMovement = new Pair<>(2,1);
        assertFalse(positionStrategy.isMovementFeasible(knightPosition, knightIllegalMovement.getX(),
                knightIllegalMovement.getY()));
        assertTrue(positionStrategy.isMovementFeasible(knightPosition, knightLegalMovement.getX(),
                knightLegalMovement.getY()));
    }
}
