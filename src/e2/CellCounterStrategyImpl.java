package e2;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CellCounterStrategyImpl implements CellCounterStrategy {

    private final Set<Pair<Integer, Integer>> setOfMines;
    private final int gridSize;

    public CellCounterStrategyImpl(int size, Set<Pair<Integer, Integer>> mines) {
        gridSize = size;
        setOfMines = mines;
    }

    @Override
    public int cellValue(Pair<Integer, Integer> cell) {
        AtomicInteger counter = new AtomicInteger();
        IntStream.rangeClosed(cell.getX() - 1, cell.getX() + 1).forEach(x ->
                IntStream.rangeClosed(cell.getY() - 1, cell.getY() + 1).forEach(y -> {
                    if (setOfMines.contains(new Pair<>(x, y))) {
                        counter.set(counter.get() + 1);
                    }
                })
        );
        return counter.get();
    }

    private boolean isInGrid(int x, int y) {
        return x < gridSize && x >= 0 && y < gridSize && y>=0;
    }

    @Override
    public Set<Cell2D<Integer>> autoClick(Cell2D<Integer> cell, Set<Cell2D<Integer>> autoClickedCells) {
        if (cell.getValue() != 0) {
            return Set.of(cell);
        }
        IntStream.rangeClosed(cell.getPosition().getX() - 1, cell.getPosition().getX() + 1).forEach(x ->
                IntStream.rangeClosed(cell.getPosition().getY() - 1, cell.getPosition().getY() + 1).forEach(y -> {
                    Pair<Integer, Integer> newPair = new Pair<>(x, y);
                    Cell2D<Integer> newCell = new Cell2D<>(newPair, cellValue(newPair));
                    if (isInGrid(x, y) && !newCell.equals(cell) && !autoClickedCells.contains(newCell)) {
                        autoClickedCells.add(newCell);
                        autoClickedCells.addAll(autoClick(newCell, autoClickedCells));
                    }
                })
        );
        return autoClickedCells;
    }
}
