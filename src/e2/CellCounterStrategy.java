package e2;

import java.util.Set;

public interface CellCounterStrategy {

    /**
     *
     * @param cell the cell to get the value
     * @return the value of the cell
     */
    int cellValue(Pair<Integer, Integer> cell);

    /**
     *
     * @param cell clicked cell
     * @param autoClickedCells an empty set to fill with all autoclicked cells
     * @return a set of cells
     */
    Set<Cell2D<Integer>> autoClick(Cell2D<Integer> cell, Set<Cell2D<Integer>> autoClickedCells);
}
