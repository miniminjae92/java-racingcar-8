package racingcar.domain;

import java.util.*;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicates(carNames);
        this.cars = carNames.stream().map(Car::new).toList();
    }

    public void moveAll(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<String> getWinnerNames() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public int getSize() {
        return cars.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return Collections.unmodifiableList(cars).iterator();
    }

    private void validateDuplicates(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}
