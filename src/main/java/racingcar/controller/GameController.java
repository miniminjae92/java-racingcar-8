package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumbers;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumbers randomNumbers;

    public GameController(InputView inputView, OutputView outputView, RandomNumbers randomNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumbers = randomNumbers;
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        int rounds = inputView.readRoundCounts();
        Cars cars = new Cars(carNames);
        RacingGame racingGame = new RacingGame(cars, randomNumbers);
        for (int i = 0; i < rounds; i++) {
            racingGame.runOneRound();
            outputView.printRound(cars);
        }
        outputView.printWinners(racingGame.getWinners());
    }
}
