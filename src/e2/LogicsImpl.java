package e2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics {

    private final int gridSize;
    private final int numberOfMines;
    private final Random random = new Random();
    private final Set<Pair<Integer, Integer>> setOfMines;
    private final Set<Cell2D<Integer>> notMinesClickedCell;
    private final CellCounterStrategy cellCounterStrategy;

    public LogicsImpl(int size, int mines) {
        gridSize = size;
        numberOfMines = mines;
        setOfMines = new HashSet<>();
        notMinesClickedCell = new HashSet<>();
        while (setOfMines.size() < numberOfMines){
          setOfMines.add(generateMinePosition());
        }
        cellCounterStrategy = new CellCounterStrategyImpl(size);
    }

    private Pair<Integer,Integer> generateMinePosition() {
        return new Pair<>(this.random.nextInt(gridSize),this.random.nextInt(gridSize));
    }

    @Override
    public Set<Pair<Integer, Integer>> getSetOfMines() {
        return setOfMines;
    }

    @Override
    public Set<Cell2D<Integer>> getNotMinesClickedCell() {
        return notMinesClickedCell;
    }

    @Override
    public boolean clickCell(Pair<Integer, Integer> position) {
        if (isMine(position)) {
            return true;
        }
        notMinesClickedCell.add(new Cell2D<>(position, cellCounterStrategy.cellValue(position, setOfMines)));
        return false;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return setOfMines.contains(position);
    }

    @Override
    public Integer getNotMineCellValue(Pair<Integer, Integer> position) {
        return notMinesClickedCell.stream()
                .filter(t -> t.getPosition().equals(position))
                .map(Cell2D::getValue)
                .findFirst()
                .orElse(0);

    }






}
