package e2;

import java.util.Set;

public interface Logics {

    Set<Pair<Integer, Integer>> getSetOfMines();

    Set<Cell2D<Integer>> getNotMinesClickedCell();

    boolean isMine(Pair<Integer, Integer> position);
}
