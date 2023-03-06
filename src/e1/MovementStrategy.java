package e1;

public interface MovementStrategy {

    /**
     * @return if the selected position is legal or not
     */
    boolean isLegalPosition(int x, int y);

    /**
     * @return if the piece eat the pawn or not
     */
    boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition);
}
