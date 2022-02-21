package racingcargame.model;

import java.util.Objects;

public class RaceCount {
    private static final int GAME_OVER = 0;

    private int count;

    public RaceCount(int count) {
        this.count = count;
    }

    public void reduceCount() {
        count--;
    }

    public boolean isZeroCount() {
        return count == GAME_OVER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCount raceCount = (RaceCount) o;
        return count == raceCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
