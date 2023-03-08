package e2;

import java.util.Objects;

public class Cell2D<T> {

    private final Pair<Integer,Integer> position;
    private final T value;
    public Cell2D(Pair<Integer, Integer> pos, T val) {
        position = pos;
        value = val;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell2D<?> cell2D = (Cell2D<?>) o;
        return position.equals(cell2D.position) && value.equals(cell2D.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, value);
    }
}
