package e2;

import java.util.HashSet;
import java.util.Set;

public class FlaggedCellStrategyImpl implements FlaggedCellStrategy {

    private final Set<Pair<Integer, Integer>> flaggedCellSet = new HashSet<>();

    @Override
    public Set<Pair<Integer, Integer>> getFlaggedCellSet() {
        return flaggedCellSet;
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return flaggedCellSet.contains(position);
    }

    @Override
    public void flagCell(Pair<Integer, Integer> position) {
        if (flaggedCellSet.contains(position)) {
            flaggedCellSet.remove(position);
        } else {
            flaggedCellSet.add(position);
        }
    }
}
