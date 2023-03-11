package e1;

public class KnightPieceStrategy implements PieceStrategy {

    public KnightPieceStrategy() {
    }

    @Override
    public boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition) {
        return pawnPosition.equals(piecePosition);
    }
}
