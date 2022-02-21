package racingcargame.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_MOVE_ACCESSIBLE = 4;

    private final String name;
    private int position;

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    boolean isWinner(Car winner) {
        return position == winner.getPosition();
    }

    void move(int number) {
        if (number >= MINIMUM_MOVE_ACCESSIBLE) {
            position ++;
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(position, car.getPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    String getName(){
        return name;
    }

    int getPosition() {
        return position;
    }
}
