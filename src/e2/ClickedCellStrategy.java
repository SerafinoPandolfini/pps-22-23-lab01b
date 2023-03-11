package e2;

import java.util.Set;

public interface ClickedCellStrategy {

    /**
     *
     * @return set of cells not containing a mine with the value of the cell
     */
    Set<Cell2D<Integer>> getClickedCell();

    /**
     *
     * @param position cell to check
     * @return if the cell is clicked or not
     */
    boolean isClicked(Pair<Integer, Integer> position);

    /**
     *
     * @param position cell to get the value
     * @return the value of the selected cell
     */
    Integer getCellValue(Pair<Integer, Integer> position);

    /**
     *
     * @param position cell to add to clickedCell
     */
    void addClickedCell(Pair<Integer, Integer> position);
}
