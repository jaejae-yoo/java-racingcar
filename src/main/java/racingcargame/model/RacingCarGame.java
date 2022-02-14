package racingcargame.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int WINNER_POSITION = 0;

    private final RaceCount raceCount;
    private Cars carRepository;

    public RacingCarGame(List<String> carNames, int raceCount) {
        this.raceCount = Objects.requireNonNull(orderToSaveRaceCount(raceCount));
        orderToSaveCars(carNames);
    }

    private void orderToSaveCars(List<String> carNames) {
        carRepository = new Cars(carNames);
    }

    private RaceCount orderToSaveRaceCount(int count) {
        return new RaceCount(count);
    }

    public void orderToReduceRaceCount() {
        raceCount.reduceCount();
    }

    public boolean isOverRace() {
        return raceCount.isZeroCount();
    }

    public List<CarVO> startRace() {
        orderToReduceRaceCount();
        carRepository.moveCars();

        return carRepository.getCars()
                .stream()
                .map(CarVO::new)
                .collect(Collectors.toList());
    }

    public List<String> findRacingGameWinner() {
        List<Car> cars = carRepository.getCars();
        cars.sort(Collections.reverseOrder());

        return cars.stream()
                .filter(car -> car.isWinner(cars.get(WINNER_POSITION)))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
