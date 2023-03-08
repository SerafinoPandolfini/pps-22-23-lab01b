package e1;

public class KnightPieceStrategy implements PieceStrategy {


    public KnightPieceStrategy() {
    }

    @Override
    public boolean isOutOfBounds(int x, int y, int size) {
        return !(x<0 || y<0 || x >= size || y >= size);
    }

    @Override
    public boolean isMovementFeasible(Pair<Integer, Integer> piecePosition, int newX, int newY) {
        int x = newX-piecePosition.getX();
        int y = newY-piecePosition.getY();
        return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
    }

    @Override
    public boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition) {
        return pawnPosition.equals(piecePosition);
    }
}
