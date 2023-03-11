package e2;

import java.util.Set;

public interface Logics {

    /**
     *
     * @return set of pairs containing a mine
     */
    Set<Pair<Integer, Integer>> getSetOfMines();

    /**
     *
     * @return set of cells not containing a mine with the value of the cell
     */
    Set<Cell2D<Integer>> getNotMinesClickedCell();

    /**
     *
     * @param position cell clicked
     * @return if the cell clicked is a mine or not
     */
    boolean clickCell(Pair<Integer, Integer> position);

    /**
     *
     * @param position cell to check
     * @return if the cell is flagged or not
     */
    boolean isFlagged(Pair<Integer, Integer> position);

    /**
     *
     * @return set of flagged cells
     */
    Set<Pair<Integer, Integer>> getFlaggedCellSet();

    /**
     *
     * @param position cell to check
     * @return if the cell is a mine or not
     */
    boolean isMine(Pair<Integer, Integer> position);

    /**
     *
     * @param position cell to get the value
     * @return the value of the selected cell
     */
    Integer getNotMineCellValue(Pair<Integer, Integer> position);

    /**
     *
     * @param position cell left-clicked
     */
    void leftClickCell(Pair<Integer, Integer> position);

    boolean isGameWon();
}
