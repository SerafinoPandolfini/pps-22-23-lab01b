package e2;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CellCounterStrategyImpl implements CellCounterStrategy {

    private int gridSize;
    public CellCounterStrategyImpl(int size) {
        gridSize = size;
    }

    @Override
    public int cellValue(Pair<Integer, Integer> cell, Set<Pair<Integer, Integer>> mines) {
        AtomicInteger counter = new AtomicInteger();
        IntStream.rangeClosed(cell.getX() - 1, cell.getX() + 1).forEach(x ->
                IntStream.rangeClosed(cell.getY() - 1, cell.getY() + 1).forEach(y -> {
                    if (mines.contains(new Pair<>(x, y))) {
                        counter.set(counter.get() + 1);
                    }
                })
        );
        return counter.get();
    }
}
