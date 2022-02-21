package racingcargame.model;

import java.util.Objects;

public class Position {
    private static final String NEGATIVE_ERROR = "[error] 양수를 입력해주세요.";
    private int position;

    public Position(int position) {
        validateNumber(position);
        this.position = position;
    }

    private void validateNumber(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR);
        }
    }

    public void addPosition() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
