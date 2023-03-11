package e2;

import java.util.Set;

public interface FlaggedCellStrategy {

    /**
     *
     * @return set of flagged cells
     */
    Set<Pair<Integer, Integer>> getFlaggedCellSet();

    /**
     *
     * @param position cell to check
     * @return if the cell is flagged or not
     */
    boolean isFlagged(Pair<Integer, Integer> position);

    /**
     *
     * @param position cell left-clicked
     */
    void flagCell(Pair<Integer, Integer> position);
}
