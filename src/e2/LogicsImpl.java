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
    private final Set<Pair<Integer, Integer>> flaggedCellSet;
    private final CellCounterStrategy cellCounterStrategy;

    public LogicsImpl(int size, int mines) {
        gridSize = size;
        numberOfMines = mines;
        setOfMines = new HashSet<>();
        notMinesClickedCell = new HashSet<>();
        flaggedCellSet = new HashSet<>();
        while (setOfMines.size() < numberOfMines){
          setOfMines.add(generateMinePosition());
        }
        cellCounterStrategy = new CellCounterStrategyImpl(size, setOfMines);
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
        System.out.println("START AUTOCLICK");
        notMinesClickedCell.addAll(cellCounterStrategy.autoClick(
                new Cell2D<>(position, cellCounterStrategy.cellValue(position)), new HashSet<>()));
        return false;
    }

    @Override
    public void leftClickCell(Pair<Integer, Integer> position) {
        if (flaggedCellSet.contains(position)) {
            flaggedCellSet.remove(position);
        } else {
            flaggedCellSet.add(position);
        }
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return flaggedCellSet.contains(position);
    }

    @Override
    public Set<Pair<Integer, Integer>> getFlaggedCellSet() {
        return flaggedCellSet;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return setOfMines.contains(position);
    }

    @Override
    public Integer getNotMineCellValue(Pair<Integer, Integer> position) {
        int unclickedCellValue = -1;
        return notMinesClickedCell.stream()
                .filter(t -> t.getPosition().equals(position))
                .map(Cell2D::getValue)
                .findFirst()
                .orElse(unclickedCellValue);
    }

    @Override
    public boolean isGameWon() {
        return (setOfMines.size() + notMinesClickedCell.size() == gridSize * gridSize);
    }
}
