package e2;

import e2.Pair;

import java.util.Set;

public interface Logics {

    Set<Pair<Integer, Integer>> getSetOfMines();

    boolean isMine(Pair<Integer, Integer> position);
}
