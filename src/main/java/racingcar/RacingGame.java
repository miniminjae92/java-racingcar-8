package racingcar;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final RandomNumbers randomNumbers;

    public RacingGame(Cars cars, RandomNumbers randomNumbers) {
        this.cars = cars;
        this.randomNumbers = randomNumbers;
    }

    public void runOneRound() {
        cars.moveAll(randomNumbers.generateRandomNumbers(cars.getSize()));
    }

    public List<String> getWinners() {
        return cars.getWinnerNames();
    }
}
