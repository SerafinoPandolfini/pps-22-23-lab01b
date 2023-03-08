package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final PieceStrategy knightStrategy;

    public LogicsImpl(int gridSize){
    	size = gridSize;
        pawn = randomEmptyPosition();
        knight = randomEmptyPosition();
		knightStrategy = new KnightPieceStrategy();
    }

	public LogicsImpl(int gridSize, Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
		size = gridSize;
		pawn = pawnPosition;
		knight = knightPosition;
		knightStrategy = new KnightPieceStrategy();
	}

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (!knightStrategy.isOutOfBounds(row, col, size)) {
			throw new IndexOutOfBoundsException();
		}
		if (knightStrategy.isMovementFeasible(knight, row, col)) {
			this.knight = new Pair<>(row,col);
			return knightStrategy.pawnIsEaten(knight, pawn);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
