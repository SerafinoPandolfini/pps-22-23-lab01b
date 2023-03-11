package e2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MIneCellStrategyImpl implements MineCellStrategy {

    private final Set<Pair<Integer, Integer>> mineSet;
    private final Random random = new Random();

    public MIneCellStrategyImpl(int gridSize, int mines) {
        mineSet = new HashSet<>();
        generateMinePosition(gridSize, mines);
    }

    private void generateMinePosition(int gridSize, int mines) {
        while (mineSet.size() < mines){
            mineSet.add(new Pair<>(this.random.nextInt(gridSize),this.random.nextInt(gridSize)));
        }
    }

    @Override
    public Set<Pair<Integer, Integer>> getMineSet() {
        return mineSet;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return mineSet.contains(position);
    }
}
