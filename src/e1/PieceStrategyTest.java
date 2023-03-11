package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceStrategyTest {

    PieceStrategy knightPieceStrategy;
    private static final int LEGAL_POSITION = 0;

    @BeforeEach
    void beforeEach() {
        knightPieceStrategy = new KnightPieceStrategy();
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
