package e2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

    private final int gridSize;
    private final Random random = new Random();
    private final Set<Pair<Integer, Integer>> mineSet;
    private final Set<Cell2D<Integer>> clickedCell;
    private final Set<Pair<Integer, Integer>> flaggedCellSet;
    private final CellCounterStrategy cellCounterStrategy;

    public LogicsImpl(int size, int mines) {
        gridSize = size;
        mineSet = new HashSet<>();
        clickedCell = new HashSet<>();
        flaggedCellSet = new HashSet<>();
        while (mineSet.size() < mines){
          mineSet.add(generateMinePosition());
        }
        cellCounterStrategy = new CellCounterStrategyImpl(size, mineSet);
    }

    private Pair<Integer,Integer> generateMinePosition() {
        return new Pair<>(this.random.nextInt(gridSize),this.random.nextInt(gridSize));
    }

    @Override
    public Set<Pair<Integer, Integer>> getMineSet() {
        return mineSet;
    }

    @Override
    public Set<Cell2D<Integer>> getClickedCell() {
        return clickedCell;
    }

    @Override
    public Set<Pair<Integer, Integer>> getFlaggedCellSet() {
        return flaggedCellSet;
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return mineSet.contains(position);
    }

    @Override
    public boolean isClicked(Pair<Integer, Integer> position) {
        return clickedCell.stream()
                .map(Cell2D::getPosition)
                .collect(Collectors.toSet())
                .contains(position);
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return flaggedCellSet.contains(position);
    }

    @Override
    public boolean clickCell(Pair<Integer, Integer> position) {
        if (isMine(position)) {
            return true;
        }
        clickedCell.addAll(cellCounterStrategy.autoClick(
                new Cell2D<>(position, cellCounterStrategy.cellValue(position)), new HashSet<>()));
        return false;
    }

    @Override
    public void flagCell(Pair<Integer, Integer> position) {
        if (flaggedCellSet.contains(position)) {
            flaggedCellSet.remove(position);
        } else {
            flaggedCellSet.add(position);
        }
    }

    @Override
    public Integer getCellValue(Pair<Integer, Integer> position) {
        int notClickedCellValue = -1;
        return clickedCell.stream()
                .filter(t -> t.getPosition().equals(position))
                .map(Cell2D::getValue)
                .findFirst()
                .orElse(notClickedCellValue);
    }

    @Override
    public boolean isGameWon() {
        return (mineSet.size() + clickedCell.size() == gridSize * gridSize);
    }
}
