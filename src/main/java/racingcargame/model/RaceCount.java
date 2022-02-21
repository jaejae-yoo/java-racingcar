package racingcargame.model;

import java.util.Objects;

public class RaceCount {
    private static final String RACE_COUNT_START_ZERO_ERROR_MESSAGE = "[error] 경주횟수는 1이상의 값을 입력해주세요.";
    private static final String COUNT_IS_ZERO = "0";
    private static final int GAME_OVER = 0;

    private int count;

    public RaceCount(int count) {
        validateRaceCount(Integer.toString(count));
        this.count = count;
    }

    private void validateRaceCount(String raceCount) {
        if (raceCount.startsWith(COUNT_IS_ZERO)) {
            throw new IllegalArgumentException(RACE_COUNT_START_ZERO_ERROR_MESSAGE);
        }
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
