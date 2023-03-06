package e1;

public class KnightMovementStrategy implements MovementStrategy {
    @Override
    public boolean isLegalPosition(int x, int y) {
        return false;
    }

    @Override
    public boolean pawnIsEaten(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition) {
        return false;
    }
}
