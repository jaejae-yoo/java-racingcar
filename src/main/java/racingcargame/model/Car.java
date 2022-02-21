package racingcargame.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_MOVE_ACCESSIBLE = 4;

    private Name name;
    private Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    boolean isWinner(Car winner) {
        return position.getPosition() == winner.getPosition();
    }

    void move(int number) {
        if (number >= MINIMUM_MOVE_ACCESSIBLE) {
            position.addPosition();
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(position.getPosition(), car.getPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    int getPosition() {
        return position.getPosition();
    }

    String getName() {
        return name.getName();
    }
}
