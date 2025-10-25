package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.RandomNumbers;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumbers randomNumbers = new RandomNumbers();
        GameController gameController = new GameController(inputView, outputView, randomNumbers);

        gameController.run();
    }
}
