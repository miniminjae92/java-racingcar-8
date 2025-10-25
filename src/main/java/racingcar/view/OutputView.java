package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void printRound(Cars cars) {
        System.out.println();
        System.out.println("실행결과");
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public void printWinners(List<String> winners) {
        System.out.println();
        System.out.print("최종 우승자 : ");
        String result = String.join(",", winners);
        System.out.println(result);
    }
}
