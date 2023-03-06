package e1;

public class KnightPieceStrategy implements PieceStrategy {


    public KnightPieceStrategy() {

    }

    @Override
    public boolean isLegalPosition(int x, int y, int size) {
        return !(x<0 || y<0 || x >= size || y >= size);
    }

    @Override
    public boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition) {
        return false;
    }
}
