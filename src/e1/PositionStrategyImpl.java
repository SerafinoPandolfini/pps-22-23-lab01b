package e1;

public class PositionStrategyImpl implements PositionStrategy {

    @Override
    public boolean isOutOfBounds(Pair<Integer, Integer> piecePosition, int size) {
        return piecePosition.getX() < 0 || piecePosition.getY() < 0 ||
                piecePosition.getX() >= size || piecePosition.getY() >= size;
    }

    @Override
    public boolean isMovementFeasible(Pair<Integer, Integer> piecePosition, int row, int col) {
        int x = row-piecePosition.getX();
        int y = col-piecePosition.getY();
        return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
    }
}
