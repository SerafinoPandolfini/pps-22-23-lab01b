package e1;

public interface PositionStrategy {

    /**
     * @return if the selected position is out of bounds or not
     */
    boolean isOutOfBounds(Pair<Integer, Integer> piecePosition, int size);

    /**
     * @return if the movement is feasible for the piece
     */
    boolean isMovementFeasible(Pair<Integer, Integer> piecePosition, int newX, int newY);
}
