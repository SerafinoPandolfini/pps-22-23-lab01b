package e2;

import java.util.Set;

public interface MineCellStrategy {

    /**
     *
     * @return set of pairs containing a mine
     */
    Set<Pair<Integer, Integer>> getMineSet();

    /**
     *
     * @param position cell to check
     * @return if the cell is a mine or not
     */
    boolean isMine(Pair<Integer, Integer> position);

}
