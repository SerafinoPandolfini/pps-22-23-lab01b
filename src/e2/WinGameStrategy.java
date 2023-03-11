package e2;

import java.util.Set;

public interface WinGameStrategy {

    /**
     *
     * @return true if the game is won
     */
    boolean isGameWon(Set<Pair<Integer, Integer>> mineSet, Set<Cell2D<Integer>> clickedCell);
}
