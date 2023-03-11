package e2;

import java.util.Set;

public class WinGameStrategyImpl implements WinGameStrategy {

    final int gridSize;
    public WinGameStrategyImpl(int size) {
        gridSize = size;
    }

    @Override
    public boolean isGameWon(Set<Pair<Integer, Integer>> mineSet, Set<Cell2D<Integer>> clickedCell) {
        return (mineSet.size() + clickedCell.size() == gridSize * gridSize);
    }
}
