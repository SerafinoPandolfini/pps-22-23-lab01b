package e2;

import e2.Pair;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics {

    private final int gridSize;
    private final int numberOfMines;

    private final Random random = new Random();

    private final Set<Pair<Integer, Integer>> setOfMines;

    public LogicsImpl(int size, int mines) {
        gridSize = size;
        numberOfMines = mines;
        setOfMines = new HashSet<>();
        while (setOfMines.size() < numberOfMines){
          setOfMines.add(generateMinePosition());
        }
    }

    private Pair<Integer,Integer> generateMinePosition() {
        return new Pair<>(this.random.nextInt(gridSize),this.random.nextInt(gridSize));
    }

    @Override
    public Set<Pair<Integer, Integer>> getSetOfMines() {
        return setOfMines;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return setOfMines.contains(position);
    }


}
