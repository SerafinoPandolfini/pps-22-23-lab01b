package e2;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClickedCellStrategyImpl implements ClickedCellStrategy {

    private final Set<Cell2D<Integer>> clickedCell;
    private final CellCounterStrategy cellCounterStrategy;
    public ClickedCellStrategyImpl(int size, Set<Pair<Integer, Integer>> mineSet) {
        clickedCell = new HashSet<>();
        cellCounterStrategy = new CellCounterStrategyImpl(size, mineSet);
    }

    @Override
    public Set<Cell2D<Integer>> getClickedCell() {
        return clickedCell;
    }

    @Override
    public boolean isClicked(Pair<Integer, Integer> position) {
        return clickedCell.stream()
                .map(Cell2D::getPosition)
                .collect(Collectors.toSet())
                .contains(position);
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
    public void addClickedCell(Pair<Integer, Integer> position) {
        clickedCell.addAll(cellCounterStrategy.autoClick(
                new Cell2D<>(position, cellCounterStrategy.cellValue(position)), new HashSet<>()));
    }
}
