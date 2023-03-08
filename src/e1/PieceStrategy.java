package e1;

public interface PieceStrategy {

    /**
     * @return if the selected position is out of bounds or not
     */
    boolean isOutOfBounds(Pair<Integer, Integer> piecePosition, int size);

    /**
     * @return if the movement is feasible for the piece
     */
    boolean isMovementFeasible(Pair<Integer, Integer> piecePosition, int newX, int newY);

    /**
     * @return if the piece eat the pawn or not
     */
    boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition);
}
