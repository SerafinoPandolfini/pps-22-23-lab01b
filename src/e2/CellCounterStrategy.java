package e2;

import java.util.Set;

public interface CellCounterStrategy {

    int cellValue(Pair<Integer, Integer> cell);

    Set<Cell2D<Integer>> autoClick(Cell2D<Integer> cell, Set<Cell2D<Integer>> autoClickedCells);
}
