package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printRound(Cars cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        String result = String.join(",", winners);
        System.out.println(result);
    }
}
