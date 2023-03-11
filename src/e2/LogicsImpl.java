package e2;

import java.util.Set;

public class LogicsImpl implements Logics {

    private final MineCellStrategy mineCellStrategy;
    private final FlaggedCellStrategy flaggedCellStrategy;
    private final ClickedCellStrategy clickedCellStrategy;
    private final WinGameStrategy winGameStrategy;

    public LogicsImpl(int size, int mines) {
        mineCellStrategy = new MIneCellStrategyImpl(size, mines);
        flaggedCellStrategy = new FlaggedCellStrategyImpl();
        clickedCellStrategy = new ClickedCellStrategyImpl(size, getMineSet());
        winGameStrategy = new WinGameStrategyImpl(size);
    }

    @Override
    public Set<Pair<Integer, Integer>> getMineSet() {
        return mineCellStrategy.getMineSet();
    }

    @Override
    public Set<Cell2D<Integer>> getClickedCell() {
        return clickedCellStrategy.getClickedCell();
    }

    @Override
    public Set<Pair<Integer, Integer>> getFlaggedCellSet() {
        return flaggedCellStrategy.getFlaggedCellSet();
    }

    @Override
    public boolean isMine(Pair<Integer, Integer> position) {
        return mineCellStrategy.isMine(position);
    }

    @Override
    public boolean isClicked(Pair<Integer, Integer> position) {
        return clickedCellStrategy.isClicked(position);
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return flaggedCellStrategy.isFlagged(position);
    }

    @Override
    public boolean clickCell(Pair<Integer, Integer> position) {
        if (isMine(position)) {
            return true;
        }
        clickedCellStrategy.addClickedCell(position);
        return false;
    }

    @Override
    public void flagCell(Pair<Integer, Integer> position) {
        flaggedCellStrategy.flagCell(position);
    }

    @Override
    public Integer getCellValue(Pair<Integer, Integer> position) {
        return clickedCellStrategy.getCellValue(position);
    }

    @Override
    public boolean isGameWon() {
        return winGameStrategy.isGameWon(getMineSet(), getClickedCell());
    }
}
