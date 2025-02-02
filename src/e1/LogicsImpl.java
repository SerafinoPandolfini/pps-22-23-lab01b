package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	private final PieceStrategy knightStrategy;
	private final PositionStrategy positionStrategy;
	private static final int ILLEGAL_POSITION = -1;
	public LogicsImpl(int gridSize){
		this(gridSize, new Pair<>(ILLEGAL_POSITION, ILLEGAL_POSITION), new Pair<>(ILLEGAL_POSITION, ILLEGAL_POSITION));
	}

	public LogicsImpl(int gridSize, Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
		knightStrategy = new KnightPieceStrategy();
		positionStrategy = new PositionStrategyImpl();
		size = gridSize;
		if (positionStrategy.isOutOfBounds(knightPosition, size) || positionStrategy.isOutOfBounds(pawnPosition, size) ||
		knightPosition.equals(pawnPosition)) {
			pawn = randomEmptyPosition();
			knight = randomEmptyPosition();
		} else {
			pawn = pawnPosition;
			knight = knightPosition;
		}
	}

	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (positionStrategy.isOutOfBounds(new Pair<>(row, col), size)) {
			throw new IndexOutOfBoundsException();
		}
		if (positionStrategy.isMovementFeasible(knight, row, col)) {
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
