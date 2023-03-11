package e2;

import java.util.Set;

public interface CellCounterStrategy {

    int cellValue(Pair<Integer, Integer> cell, Set<Pair<Integer, Integer>> mines);

}
