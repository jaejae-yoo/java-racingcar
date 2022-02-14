package racingcargame.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();
    private List<Integer> numbers;

    public RandomNumberGenerator(int start, int end) {
        RandomNumber randomNumber = RandomNumber.of(start, end);
        numbers = randomNumber.getNumbers();
    }

    public int pickRandomNumber() {
        Collections.shuffle(numbers);
        return numbers.get(RANDOM.nextInt(numbers.size()));
    }
}
