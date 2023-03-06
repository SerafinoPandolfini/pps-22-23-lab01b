package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovementStrategyTest {

    MovementStrategy movementStrategy;

    @BeforeEach
    void beforeEach(){
        movementStrategy = new KnightMovementStrategy();
    }

    @Test
    void testInitialPosition() {
    }

}
