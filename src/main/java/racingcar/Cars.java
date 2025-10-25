package racingcar;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Car 객체를 생성한다.
// 무작위 값을 받아서 객체마다 전달한다.
// 중복된 이름에 대해서 검사한다.
public class Cars {

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

    private void validateDuplicates(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}
