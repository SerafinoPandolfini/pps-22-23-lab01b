package e1;

public interface PieceStrategy {


    /**
     * @return if the piece eat the pawn or not
     */
    boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition);
}
